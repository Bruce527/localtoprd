// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpOptionDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPFAndIImpOptionSchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpOptionSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPFAndIImpOptionDBSet extends LNPFAndIImpOptionSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPFAndIImpOptionDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPFAndIImpOption");
		mflag = true;
	}

	public LNPFAndIImpOptionDBSet()
	{
		mflag = false;
		db = new DBOper("LNPFAndIImpOption");
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
			tError.moduleName = "LNPFAndIImpOptionDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPFAndIImpOption WHERE  OptionId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOptionId());
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
			tError.moduleName = "LNPFAndIImpOptionDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPFAndIImpOption SET  ImpartId = ? , QuestionId = ? , OptionId = ? , OptionOrder = ? , OptionContent = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getQuestionId() == null || get(i).getQuestionId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionId());
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOptionId());
				if (get(i).getOptionOrder() == null || get(i).getOptionOrder().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOptionOrder());
				if (get(i).getOptionContent() == null || get(i).getOptionContent().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOptionContent());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOptionId());
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
			tError.moduleName = "LNPFAndIImpOptionDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPFAndIImpOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getQuestionId() == null || get(i).getQuestionId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionId());
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOptionId());
				if (get(i).getOptionOrder() == null || get(i).getOptionOrder().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOptionOrder());
				if (get(i).getOptionContent() == null || get(i).getOptionContent().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOptionContent());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyTime());
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
			tError.moduleName = "LNPFAndIImpOptionDBSet";
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
