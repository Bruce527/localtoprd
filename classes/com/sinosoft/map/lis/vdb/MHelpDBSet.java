// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHelpDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MHelpSchema;
import com.sinosoft.map.lis.vschema.MHelpSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MHelpDBSet extends MHelpSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MHelpDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MHelp");
		mflag = true;
	}

	public MHelpDBSet()
	{
		mflag = false;
		db = new DBOper("MHelp");
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
			tError.moduleName = "MHelpDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			pstmt = con.prepareStatement("DELETE FROM MHelp WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
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
			tError.moduleName = "MHelpDBSet";
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
			pstmt = con.prepareStatement("UPDATE MHelp SET  ID = ? , ManageCom = ? , Application = ? , Person = ? , Email = ? , Tel = ? , VF1 = ? , VF2 = ? , VF3 = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getApplication() == null || get(i).getApplication().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getApplication());
				if (get(i).getPerson() == null || get(i).getPerson().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPerson());
				if (get(i).getEmail() == null || get(i).getEmail().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getEmail());
				if (get(i).getTel() == null || get(i).getTel().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getTel());
				if (get(i).getVF1() == null || get(i).getVF1().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getVF1());
				if (get(i).getVF2() == null || get(i).getVF2().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getVF2());
				if (get(i).getVF3() == null || get(i).getVF3().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getVF3());
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getID());
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
			tError.moduleName = "MHelpDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MHelp VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getManageCom());
				if (get(i).getApplication() == null || get(i).getApplication().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getApplication());
				if (get(i).getPerson() == null || get(i).getPerson().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPerson());
				if (get(i).getEmail() == null || get(i).getEmail().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getEmail());
				if (get(i).getTel() == null || get(i).getTel().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getTel());
				if (get(i).getVF1() == null || get(i).getVF1().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getVF1());
				if (get(i).getVF2() == null || get(i).getVF2().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getVF2());
				if (get(i).getVF3() == null || get(i).getVF3().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getVF3());
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
			tError.moduleName = "MHelpDBSet";
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
