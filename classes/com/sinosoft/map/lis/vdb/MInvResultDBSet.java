// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvResultDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MInvResultSchema;
import com.sinosoft.map.lis.vschema.MInvResultSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvResultDBSet extends MInvResultSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MInvResultDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MInvResult");
		mflag = true;
	}

	public MInvResultDBSet()
	{
		mflag = false;
		db = new DBOper("MInvResult");
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
			tError.moduleName = "MInvResultDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MInvResult WHERE  ResultID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultID() == null || get(i).getResultID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultID());
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
			tError.moduleName = "MInvResultDBSet";
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
			pstmt = con.prepareStatement("UPDATE MInvResult SET  ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultID() == null || get(i).getResultID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultID());
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopicID());
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionID());
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOptionID());
				if (get(i).getOtherAnswer() == null || get(i).getOtherAnswer().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOtherAnswer());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentCode());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getNF01());
				pstmt.setInt(10, get(i).getIF01());
				pstmt.setDouble(11, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getModifyTime());
				if (get(i).getResultID() == null || get(i).getResultID().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getResultID());
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
			tError.moduleName = "MInvResultDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MInvResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultID() == null || get(i).getResultID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultID());
				if (get(i).getTopicID() == null || get(i).getTopicID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getTopicID());
				if (get(i).getQuestionID() == null || get(i).getQuestionID().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionID());
				if (get(i).getOptionID() == null || get(i).getOptionID().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getOptionID());
				if (get(i).getOtherAnswer() == null || get(i).getOtherAnswer().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOtherAnswer());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAgentCode());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getManageCom());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getNF01());
				pstmt.setInt(10, get(i).getIF01());
				pstmt.setDouble(11, get(i).getDF02());
				if (get(i).getDate01() == null || get(i).getDate01().equals("null"))
					pstmt.setDate(12, null);
				else
					pstmt.setDate(12, Date.valueOf(get(i).getDate01()));
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(17, null);
				else
					pstmt.setDate(17, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getModifyTime());
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
			tError.moduleName = "MInvResultDBSet";
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
