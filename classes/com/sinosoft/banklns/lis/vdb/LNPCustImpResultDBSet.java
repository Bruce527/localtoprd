// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpResultDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCustImpResultSchema;
import com.sinosoft.banklns.lis.vschema.LNPCustImpResultSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCustImpResultDBSet extends LNPCustImpResultSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCustImpResultDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCustImpResult");
		mflag = true;
	}

	public LNPCustImpResultDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCustImpResult");
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
			tError.moduleName = "LNPCustImpResultDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCustImpResult WHERE  ResultId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
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
			tError.moduleName = "LNPCustImpResultDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCustImpResult SET  ResultId = ? , ImpartId = ? , QuestionId = ? , QuestionType = ? , QueInnerOrder = ? , GrpContNo = ? , ContNo = ? , ProposalContNo = ? , CustomerNo = ? , CustomerId = ? , OptionId = ? , Answer = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultId = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getImpartId());
				if (get(i).getQuestionId() == null || get(i).getQuestionId().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionId());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getQuestionType());
				if (get(i).getQueInnerOrder() == null || get(i).getQueInnerOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getQueInnerOrder());
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getProposalContNo());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCustomerNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCustomerId());
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOptionId());
				if (get(i).getAnswer() == null || get(i).getAnswer().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAnswer());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getManageCom());
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
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getResultId());
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
			tError.moduleName = "LNPCustImpResultDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCustImpResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getResultId() == null || get(i).getResultId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getResultId());
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getImpartId());
				if (get(i).getQuestionId() == null || get(i).getQuestionId().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionId());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getQuestionType());
				if (get(i).getQueInnerOrder() == null || get(i).getQueInnerOrder().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getQueInnerOrder());
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getProposalContNo());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCustomerNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCustomerId());
				if (get(i).getOptionId() == null || get(i).getOptionId().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getOptionId());
				if (get(i).getAnswer() == null || get(i).getAnswer().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getAnswer());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getManageCom());
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
			tError.moduleName = "LNPCustImpResultDBSet";
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
