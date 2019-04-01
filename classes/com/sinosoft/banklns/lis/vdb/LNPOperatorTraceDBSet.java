// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPOperatorTraceDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPOperatorTraceSchema;
import com.sinosoft.banklns.lis.vschema.LNPOperatorTraceSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPOperatorTraceDBSet extends LNPOperatorTraceSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPOperatorTraceDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPOperatorTrace");
		mflag = true;
	}

	public LNPOperatorTraceDBSet()
	{
		mflag = false;
		db = new DBOper("LNPOperatorTrace");
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
			tError.moduleName = "LNPOperatorTraceDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPOperatorTrace WHERE  ID = ?");
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
			tError.moduleName = "LNPOperatorTraceDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPOperatorTrace SET  ID = ? , Contno = ? , Operator = ? , OperatorDate = ? , OperatorTime = ? , OperatorType = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Varc5 = ? , Varc3 = ? , Varc4 = ? , Varc6 = ? , Date1 = ? , Date2 = ? WHERE  ID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getContno() == null || get(i).getContno().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContno());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOperator());
				if (get(i).getOperatorDate() == null || get(i).getOperatorDate().equals("null"))
					pstmt.setDate(4, null);
				else
					pstmt.setDate(4, Date.valueOf(get(i).getOperatorDate()));
				if (get(i).getOperatorTime() == null || get(i).getOperatorTime().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperatorTime());
				if (get(i).getOperatorType() == null || get(i).getOperatorType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperatorType());
				pstmt.setInt(7, get(i).getInt1());
				pstmt.setInt(8, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getVarc2());
				if (get(i).getVarc5() == null || get(i).getVarc5().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getVarc5());
				if (get(i).getVarc3() == null || get(i).getVarc3().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVarc3());
				if (get(i).getVarc4() == null || get(i).getVarc4().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc4());
				if (get(i).getVarc6() == null || get(i).getVarc6().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc6());
				if (get(i).getDate1() == null || get(i).getDate1().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getDate1()));
				if (get(i).getDate2() == null || get(i).getDate2().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getDate2()));
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getID());
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
			tError.moduleName = "LNPOperatorTraceDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPOperatorTrace VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getContno() == null || get(i).getContno().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContno());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOperator());
				if (get(i).getOperatorDate() == null || get(i).getOperatorDate().equals("null"))
					pstmt.setDate(4, null);
				else
					pstmt.setDate(4, Date.valueOf(get(i).getOperatorDate()));
				if (get(i).getOperatorTime() == null || get(i).getOperatorTime().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperatorTime());
				if (get(i).getOperatorType() == null || get(i).getOperatorType().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperatorType());
				pstmt.setInt(7, get(i).getInt1());
				pstmt.setInt(8, get(i).getInt2());
				if (get(i).getVarc1() == null || get(i).getVarc1().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getVarc1());
				if (get(i).getVarc2() == null || get(i).getVarc2().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getVarc2());
				if (get(i).getVarc5() == null || get(i).getVarc5().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getVarc5());
				if (get(i).getVarc3() == null || get(i).getVarc3().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVarc3());
				if (get(i).getVarc4() == null || get(i).getVarc4().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getVarc4());
				if (get(i).getVarc6() == null || get(i).getVarc6().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getVarc6());
				if (get(i).getDate1() == null || get(i).getDate1().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getDate1()));
				if (get(i).getDate2() == null || get(i).getDate2().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getDate2()));
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
			tError.moduleName = "LNPOperatorTraceDBSet";
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
