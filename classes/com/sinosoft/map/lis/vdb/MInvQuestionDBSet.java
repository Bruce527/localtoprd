// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvQuestionDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MInvQuestionSchema;
import com.sinosoft.map.lis.vschema.MInvQuestionSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvQuestionDBSet extends MInvQuestionSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MInvQuestionDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MInvQuestion");
		mflag = true;
	}

	public MInvQuestionDBSet()
	{
		mflag = false;
		db = new DBOper("MInvQuestion");
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
			tError.moduleName = "MInvQuestionDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MInvQuestion WHERE  QuestionID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getQuestionID());
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
			tError.moduleName = "MInvQuestionDBSet";
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
			pstmt = con.prepareStatement("UPDATE MInvQuestion SET  QuestionID = ? , TopicID = ? , Question = ? , Depiction = ? , QuestionType = ? , QuestionOrder = ? , ParentID = ? , State = ? , ChildFlag = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  QuestionID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getQuestionID());
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopicID());
				if (get(i).getQuestion() == null || get(i).getQuestion().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestion());
				if (get(i).getDepiction() == null || get(i).getDepiction().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getDepiction());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getQuestionType());
				pstmt.setInt(6, get(i).getQuestionOrder());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getParentID());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getState());
				if (get(i).getChildFlag() == null || get(i).getChildFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getChildFlag());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getNF01());
				pstmt.setInt(12, get(i).getIF01());
				pstmt.setDouble(13, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getModifyTime());
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getQuestionID());
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
			tError.moduleName = "MInvQuestionDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MInvQuestion VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getQuestionID());
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopicID());
				if (get(i).getQuestion() == null || get(i).getQuestion().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestion());
				if (get(i).getDepiction() == null || get(i).getDepiction().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getDepiction());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getQuestionType());
				pstmt.setInt(6, get(i).getQuestionOrder());
				if (get(i).getParentID() == null || get(i).getParentID().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getParentID());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getState());
				if (get(i).getChildFlag() == null || get(i).getChildFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getChildFlag());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getNF01());
				pstmt.setInt(12, get(i).getIF01());
				pstmt.setDouble(13, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(19, null);
				else
					pstmt.setDate(19, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getModifyTime());
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
			tError.moduleName = "MInvQuestionDBSet";
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
