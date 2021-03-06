// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvOptionDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MInvOptionSchema;
import com.sinosoft.map.lis.vschema.MInvOptionSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvOptionDBSet extends MInvOptionSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MInvOptionDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MInvOption");
		mflag = true;
	}

	public MInvOptionDBSet()
	{
		mflag = false;
		db = new DBOper("MInvOption");
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
			tError.moduleName = "MInvOptionDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MInvOption WHERE  OptionID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOptionID());
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
			tError.moduleName = "MInvOptionDBSet";
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
			pstmt = con.prepareStatement("UPDATE MInvOption SET  OptionID = ? , QuestionID = ? , Option = ? , OptionOrder = ? , State = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOptionID());
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionID());
				if (get(i).getOption() == null || get(i).getOption().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOption());
				pstmt.setInt(4, get(i).getOptionOrder());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getState());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNF01());
				pstmt.setInt(8, get(i).getIF01());
				pstmt.setDouble(9, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getOptionID());
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
			tError.moduleName = "MInvOptionDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MInvOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getOptionID());
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionID());
				if (get(i).getOption() == null || get(i).getOption().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getOption());
				pstmt.setInt(4, get(i).getOptionOrder());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getState());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getNF01());
				pstmt.setInt(8, get(i).getIF01());
				pstmt.setDouble(9, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(10, null);
				else
					pstmt.setDate(10, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
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
			tError.moduleName = "MInvOptionDBSet";
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
