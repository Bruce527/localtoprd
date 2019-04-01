// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOccupationDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPOccupationSchema;
import com.sinosoft.banklns.lis.vschema.LNPOccupationSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPOccupationDBSet extends LNPOccupationSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPOccupationDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPOccupation");
		mflag = true;
	}

	public LNPOccupationDBSet()
	{
		mflag = false;
		db = new DBOper("LNPOccupation");
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
			tError.moduleName = "LNPOccupationDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPOccupation WHERE  OccupationCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOccupationCode());
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
			tError.moduleName = "LNPOccupationDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPOccupation SET  OccupationCode = ? , OccupationName = ? , WorkType = ? , WorkName = ? , LifeRate = ? , HiRate = ? , PaRate = ? , WpRate = ? , BackRate1 = ? , BackRate2 = ? , RelaCode = ? WHERE  OccupationCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOccupationCode());
				if (get(i).getOccupationName() == null || get(i).getOccupationName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getOccupationName());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getWorkType());
				if (get(i).getWorkName() == null || get(i).getWorkName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getWorkName());
				if (get(i).getLifeRate() == null || get(i).getLifeRate().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getLifeRate());
				if (get(i).getHiRate() == null || get(i).getHiRate().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getHiRate());
				if (get(i).getPaRate() == null || get(i).getPaRate().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPaRate());
				if (get(i).getWpRate() == null || get(i).getWpRate().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getWpRate());
				if (get(i).getBackRate1() == null || get(i).getBackRate1().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBackRate1());
				if (get(i).getBackRate2() == null || get(i).getBackRate2().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getBackRate2());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRelaCode());
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOccupationCode());
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
			tError.moduleName = "LNPOccupationDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPOccupation VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOccupationCode() == null || get(i).getOccupationCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOccupationCode());
				if (get(i).getOccupationName() == null || get(i).getOccupationName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getOccupationName());
				if (get(i).getWorkType() == null || get(i).getWorkType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getWorkType());
				if (get(i).getWorkName() == null || get(i).getWorkName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getWorkName());
				if (get(i).getLifeRate() == null || get(i).getLifeRate().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getLifeRate());
				if (get(i).getHiRate() == null || get(i).getHiRate().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getHiRate());
				if (get(i).getPaRate() == null || get(i).getPaRate().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPaRate());
				if (get(i).getWpRate() == null || get(i).getWpRate().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getWpRate());
				if (get(i).getBackRate1() == null || get(i).getBackRate1().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getBackRate1());
				if (get(i).getBackRate2() == null || get(i).getBackRate2().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getBackRate2());
				if (get(i).getRelaCode() == null || get(i).getRelaCode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getRelaCode());
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
			tError.moduleName = "LNPOccupationDBSet";
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
