// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CaseFileDownlLogDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.CaseFileDownlLogSchema;
import com.sinosoft.map.lis.vschema.CaseFileDownlLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class CaseFileDownlLogDBSet extends CaseFileDownlLogSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public CaseFileDownlLogDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "CaseFileDownlLog");
		mflag = true;
	}

	public CaseFileDownlLogDBSet()
	{
		mflag = false;
		db = new DBOper("CaseFileDownlLog");
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
			tError.moduleName = "CaseFileDownlLogDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM CaseFileDownlLog WHERE  Id = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getId() == null || get(i).getId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getId());
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
			tError.moduleName = "CaseFileDownlLogDBSet";
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
			pstmt = con.prepareStatement("UPDATE CaseFileDownlLog SET  Id = ? , FileDate = ? , FDownDate = ? , FDownTime = ? , Flag = ? , ModifyDate = ? , ModityTime = ? , LastOperator = ? , BY1 = ? , BY2 = ? , BY3 = ? , BY4 = ? WHERE  Id = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getId() == null || get(i).getId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getId());
				if (get(i).getFileDate() == null || get(i).getFileDate().equals("null"))
					pstmt.setDate(2, null);
				else
					pstmt.setDate(2, Date.valueOf(get(i).getFileDate()));
				if (get(i).getFDownDate() == null || get(i).getFDownDate().equals("null"))
					pstmt.setDate(3, null);
				else
					pstmt.setDate(3, Date.valueOf(get(i).getFDownDate()));
				if (get(i).getFDownTime() == null || get(i).getFDownTime().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFDownTime());
				if (get(i).getFlag() == null || get(i).getFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getFlag());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModityTime() == null || get(i).getModityTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getModityTime());
				if (get(i).getLastOperator() == null || get(i).getLastOperator().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getLastOperator());
				if (get(i).getBY1() == null || get(i).getBY1().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getBY1()));
				if (get(i).getBY2() == null || get(i).getBY2().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getBY2()));
				if (get(i).getBY3() == null || get(i).getBY3().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getBY3());
				if (get(i).getBY4() == null || get(i).getBY4().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getBY4());
				if (get(i).getId() == null || get(i).getId().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getId());
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
			tError.moduleName = "CaseFileDownlLogDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO CaseFileDownlLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getId() == null || get(i).getId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getId());
				if (get(i).getFileDate() == null || get(i).getFileDate().equals("null"))
					pstmt.setDate(2, null);
				else
					pstmt.setDate(2, Date.valueOf(get(i).getFileDate()));
				if (get(i).getFDownDate() == null || get(i).getFDownDate().equals("null"))
					pstmt.setDate(3, null);
				else
					pstmt.setDate(3, Date.valueOf(get(i).getFDownDate()));
				if (get(i).getFDownTime() == null || get(i).getFDownTime().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFDownTime());
				if (get(i).getFlag() == null || get(i).getFlag().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getFlag());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModityTime() == null || get(i).getModityTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getModityTime());
				if (get(i).getLastOperator() == null || get(i).getLastOperator().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getLastOperator());
				if (get(i).getBY1() == null || get(i).getBY1().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getBY1()));
				if (get(i).getBY2() == null || get(i).getBY2().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getBY2()));
				if (get(i).getBY3() == null || get(i).getBY3().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getBY3());
				if (get(i).getBY4() == null || get(i).getBY4().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getBY4());
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
			tError.moduleName = "CaseFileDownlLogDBSet";
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
