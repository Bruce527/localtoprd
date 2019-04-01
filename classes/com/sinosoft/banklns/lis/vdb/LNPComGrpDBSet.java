// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPComGrpDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPComGrpSchema;
import com.sinosoft.banklns.lis.vschema.LNPComGrpSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPComGrpDBSet extends LNPComGrpSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPComGrpDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPComGrp");
		mflag = true;
	}

	public LNPComGrpDBSet()
	{
		mflag = false;
		db = new DBOper("LNPComGrp");
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
			tError.moduleName = "LNPComGrpDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPComGrp WHERE  ComGrpCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
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
			tError.moduleName = "LNPComGrpDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPComGrp SET  ComGrpCode = ? , ComGrpName = ? , ComGrpDescription = ? , ComSign = ? , ComGrpType = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ComGrpCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
				if (get(i).getComGrpName() == null || get(i).getComGrpName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getComGrpName());
				if (get(i).getComGrpDescription() == null || get(i).getComGrpDescription().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getComGrpDescription());
				if (get(i).getComSign() == null || get(i).getComSign().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getComSign());
				if (get(i).getComGrpType() == null || get(i).getComGrpType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getComGrpType());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMakeTime());
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getComGrpCode());
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
			tError.moduleName = "LNPComGrpDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPComGrp VALUES( ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComGrpCode() == null || get(i).getComGrpCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComGrpCode());
				if (get(i).getComGrpName() == null || get(i).getComGrpName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getComGrpName());
				if (get(i).getComGrpDescription() == null || get(i).getComGrpDescription().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getComGrpDescription());
				if (get(i).getComSign() == null || get(i).getComSign().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getComSign());
				if (get(i).getComGrpType() == null || get(i).getComGrpType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getComGrpType());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(7, null);
				else
					pstmt.setDate(7, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMakeTime());
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
			tError.moduleName = "LNPComGrpDBSet";
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
