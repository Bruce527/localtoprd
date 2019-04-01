// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpartDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPFAndIImpartSchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpartSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPFAndIImpartDBSet extends LNPFAndIImpartSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPFAndIImpartDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPFAndIImpart");
		mflag = true;
	}

	public LNPFAndIImpartDBSet()
	{
		mflag = false;
		db = new DBOper("LNPFAndIImpart");
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
			tError.moduleName = "LNPFAndIImpartDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPFAndIImpart WHERE  ImpartId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
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
			tError.moduleName = "LNPFAndIImpartDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPFAndIImpart SET  ImpartId = ? , ImpartName = ? , ImpartVer = ? , ImpartContent = ? , QuestionSum = ? , Operator = ? , ManageCom = ? , MakeTime = ? , MakeDate = ? , ModifyDate = ? , ModifyTime = ? , p1 = ? , p2 = ? , p3 = ? , p4 = ? WHERE  ImpartId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getImpartName() == null || get(i).getImpartName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getImpartName());
				if (get(i).getImpartVer() == null || get(i).getImpartVer().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getImpartVer());
				if (get(i).getImpartContent() == null || get(i).getImpartContent().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getImpartContent());
				pstmt.setInt(5, get(i).getQuestionSum());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMakeTime());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getP1());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getP2());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getP3());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP4());
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getImpartId());
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
			tError.moduleName = "LNPFAndIImpartDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPFAndIImpart VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getImpartName() == null || get(i).getImpartName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getImpartName());
				if (get(i).getImpartVer() == null || get(i).getImpartVer().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getImpartVer());
				if (get(i).getImpartContent() == null || get(i).getImpartContent().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getImpartContent());
				pstmt.setInt(5, get(i).getQuestionSum());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMakeTime());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				if (get(i).getP1() == null || get(i).getP1().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getP1());
				if (get(i).getP2() == null || get(i).getP2().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getP2());
				if (get(i).getP3() == null || get(i).getP3().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getP3());
				if (get(i).getP4() == null || get(i).getP4().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getP4());
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
			tError.moduleName = "LNPFAndIImpartDBSet";
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
