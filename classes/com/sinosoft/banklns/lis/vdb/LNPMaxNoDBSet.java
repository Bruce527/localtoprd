// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPMaxNoDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPMaxNoSchema;
import com.sinosoft.banklns.lis.vschema.LNPMaxNoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPMaxNoDBSet extends LNPMaxNoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPMaxNoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPMaxNo");
		mflag = true;
	}

	public LNPMaxNoDBSet()
	{
		mflag = false;
		db = new DBOper("LNPMaxNo");
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
			tError.moduleName = "LNPMaxNoDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPMaxNo WHERE  NoType = ? AND NoLimit = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNoType() == null || get(i).getNoType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNoType());
				if (get(i).getNoLimit() == null || get(i).getNoLimit().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNoLimit());
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
			tError.moduleName = "LNPMaxNoDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPMaxNo SET  NoType = ? , NoLimit = ? , MaxNo = ? WHERE  NoType = ? AND NoLimit = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNoType() == null || get(i).getNoType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNoType());
				if (get(i).getNoLimit() == null || get(i).getNoLimit().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNoLimit());
				pstmt.setInt(3, get(i).getMaxNo());
				if (get(i).getNoType() == null || get(i).getNoType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getNoType());
				if (get(i).getNoLimit() == null || get(i).getNoLimit().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getNoLimit());
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
			tError.moduleName = "LNPMaxNoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPMaxNo VALUES( ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getNoType() == null || get(i).getNoType().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getNoType());
				if (get(i).getNoLimit() == null || get(i).getNoLimit().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNoLimit());
				pstmt.setInt(3, get(i).getMaxNo());
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
			tError.moduleName = "LNPMaxNoDBSet";
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
