// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCustImpQueDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCustImpQueSchema;
import com.sinosoft.banklns.lis.vschema.LNPCustImpQueSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCustImpQueDBSet extends LNPCustImpQueSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCustImpQueDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCustImpQue");
		mflag = true;
	}

	public LNPCustImpQueDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCustImpQue");
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
			tError.moduleName = "LNPCustImpQueDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCustImpQue WHERE  Questionid = ? AND InnerOrder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getQuestionid() == null || get(i).getQuestionid().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getQuestionid());
				if (get(i).getInnerOrder() == null || get(i).getInnerOrder().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getInnerOrder());
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
			tError.moduleName = "LNPCustImpQueDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCustImpQue SET  ImpartId = ? , Questionid = ? , QuestionType = ? , Content1 = ? , Content2 = ? , QueOrder = ? , InnerOrder = ? , OutQueId = ? , InnerQueNum = ? , ParentId = ? , ChildQueNum = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  Questionid = ? AND InnerOrder = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getQuestionid() == null || get(i).getQuestionid().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionid());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionType());
				if (get(i).getContent1() == null || get(i).getContent1().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getContent1());
				if (get(i).getContent2() == null || get(i).getContent2().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getContent2());
				if (get(i).getQueOrder() == null || get(i).getQueOrder().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getQueOrder());
				if (get(i).getInnerOrder() == null || get(i).getInnerOrder().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getInnerOrder());
				if (get(i).getOutQueId() == null || get(i).getOutQueId().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOutQueId());
				if (get(i).getInnerQueNum() == null || get(i).getInnerQueNum().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getInnerQueNum());
				if (get(i).getParentId() == null || get(i).getParentId().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getParentId());
				if (get(i).getChildQueNum() == null || get(i).getChildQueNum().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getChildQueNum());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyTime());
				if (get(i).getQuestionid() == null || get(i).getQuestionid().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getQuestionid());
				if (get(i).getInnerOrder() == null || get(i).getInnerOrder().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getInnerOrder());
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
			tError.moduleName = "LNPCustImpQueDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCustImpQue VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getImpartId() == null || get(i).getImpartId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getImpartId());
				if (get(i).getQuestionid() == null || get(i).getQuestionid().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getQuestionid());
				if (get(i).getQuestionType() == null || get(i).getQuestionType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getQuestionType());
				if (get(i).getContent1() == null || get(i).getContent1().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getContent1());
				if (get(i).getContent2() == null || get(i).getContent2().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getContent2());
				if (get(i).getQueOrder() == null || get(i).getQueOrder().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getQueOrder());
				if (get(i).getInnerOrder() == null || get(i).getInnerOrder().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getInnerOrder());
				if (get(i).getOutQueId() == null || get(i).getOutQueId().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getOutQueId());
				if (get(i).getInnerQueNum() == null || get(i).getInnerQueNum().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getInnerQueNum());
				if (get(i).getParentId() == null || get(i).getParentId().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getParentId());
				if (get(i).getChildQueNum() == null || get(i).getChildQueNum().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getChildQueNum());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getManageCom());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyTime());
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
			tError.moduleName = "LNPCustImpQueDBSet";
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
