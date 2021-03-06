// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvResultDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MInvResultSchema;
import com.sinosoft.map.lis.vschema.MInvResultSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvResultDB extends MInvResultSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MInvResultDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MInvResult");
		mflag = true;
	}

	public MInvResultDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MInvResult");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MInvResultSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MInvResultSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return -1;
		} else
		{
			return tCount;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("DELETE FROM MInvResult WHERE  ResultID = ?");
			if (getResultID() == null || getResultID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("UPDATE MInvResult SET  ResultID = ? , TopicID = ? , QuestionID = ? , OptionID = ? , OtherAnswer = ? , AgentCode = ? , ManageCom = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ResultID = ?");
			if (getResultID() == null || getResultID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultID());
			if (getTopicID() == null || getTopicID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getTopicID());
			if (getQuestionID() == null || getQuestionID().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getQuestionID());
			if (getOptionID() == null || getOptionID().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOptionID());
			if (getOtherAnswer() == null || getOtherAnswer().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOtherAnswer());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAgentCode());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getManageCom());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getNF01());
			pstmt.setInt(10, getIF01());
			pstmt.setDouble(11, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getModifyTime());
			if (getResultID() == null || getResultID().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getResultID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("INSERT INTO MInvResult VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getResultID() == null || getResultID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getResultID());
			if (getTopicID() == null || getTopicID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getTopicID());
			if (getQuestionID() == null || getQuestionID().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getQuestionID());
			if (getOptionID() == null || getOptionID().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOptionID());
			if (getOtherAnswer() == null || getOtherAnswer().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOtherAnswer());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAgentCode());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getManageCom());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getNF01());
			pstmt.setInt(10, getIF01());
			pstmt.setDouble(11, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean getInfo()
	{
		PreparedStatement pstmt;
		ResultSet rs;
		pstmt = null;
		rs = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		int i;
		pstmt = con.prepareStatement("SELECT * FROM MInvResult WHERE  ResultID = ?", 1003, 1007);
		if (getResultID() == null || getResultID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getResultID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "MInvResultDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "取数失败!";
		mErrors.addOneError(tError);
		try
		{
			rs.close();
		}
		catch (Exception exception4) { }
		try
		{
			pstmt.close();
		}
		catch (Exception exception5) { }
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception6) { }
		return false;
label0:
		{
			try
			{
				try
				{
					rs.close();
				}
				catch (Exception exception1) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception2) { }
				if (i != 0)
					break label0;
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "MInvResultDB";
				tError.functionName = "getInfo";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					rs.close();
				}
				catch (Exception exception7) { }
				try
				{
					pstmt.close();
				}
				catch (Exception exception8) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception9) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public MInvResultSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvResultSet aMInvResultSet = new MInvResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MInvResult");
			MInvResultSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MInvResultSchema s1;
			for (; rs.next(); aMInvResultSet.add(s1))
			{
				i++;
				s1 = new MInvResultSchema();
				s1.setSchema(rs, i);
			}

			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aMInvResultSet;
	}

	public MInvResultSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvResultSet aMInvResultSet = new MInvResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MInvResultSchema s1;
			for (; rs.next(); aMInvResultSet.add(s1))
			{
				i++;
				s1 = new MInvResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MInvResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
			}

			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aMInvResultSet;
	}

	public MInvResultSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvResultSet aMInvResultSet = new MInvResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MInvResult");
			MInvResultSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				MInvResultSchema s1 = new MInvResultSchema();
				s1.setSchema(rs, i);
				aMInvResultSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception4) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception5) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "query";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aMInvResultSet;
	}

	public MInvResultSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvResultSet aMInvResultSet = new MInvResultSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			while (rs.next()) 
			{
				if (++i < nStart)
					continue;
				if (i >= nStart + nCount)
					break;
				MInvResultSchema s1 = new MInvResultSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MInvResultDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMInvResultSet.add(s1);
			}
			try
			{
				rs.close();
			}
			catch (Exception exception1) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception2) { }
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "executeQuery";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				rs.close();
			}
			catch (Exception exception3) { }
			try
			{
				stmt.close();
			}
			catch (Exception exception4) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception5) { }
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return aMInvResultSet;
	}

	public boolean update(String strWherePart)
	{
label0:
		{
			Statement stmt = null;
			if (!mflag)
				con = DBConnPool.getConnection();
			try
			{
				stmt = con.createStatement(1003, 1007);
				SQLString sqlObj = new SQLString("MInvResult");
				MInvResultSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MInvResult ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MInvResultDB";
				tError.functionName = "update";
				tError.errorMessage = "更新数据失败!";
				mErrors.addOneError(tError);
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception3) { }
			}
			catch (Exception e)
			{
				CError tError = new CError();
				tError.moduleName = "MInvResultDB";
				tError.functionName = "update";
				tError.errorMessage = e.toString();
				mErrors.addOneError(tError);
				try
				{
					stmt.close();
				}
				catch (Exception exception1) { }
				if (!mflag)
					try
					{
						con.close();
					}
					catch (Exception exception2) { }
				return false;
			}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean prepareData(String strSQL)
	{
		if (mResultSet != null)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "数据集非空，程序在准备数据集之后，没有关闭！";
			mErrors.addOneError(tError);
			return false;
		}
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			mStatement = con.createStatement(1003, 1007);
			mResultSet = mStatement.executeQuery(StrTool.GBKToUnicode(strSQL));
		}
		catch (Exception e)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "prepareData";
			tError.errorMessage = e.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
			}
			catch (Exception exception1) { }
			try
			{
				mStatement.close();
			}
			catch (Exception exception2) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception3) { }
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception exception) { }
		return true;
	}

	public boolean hasMoreData()
	{
		boolean flag = true;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return false;
		}
		try
		{
			flag = mResultSet.next();
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return false;
		}
		return flag;
	}

	public MInvResultSet getData()
	{
		int tCount = 0;
		MInvResultSet tMInvResultSet = new MInvResultSet();
		MInvResultSchema tMInvResultSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMInvResultSchema = new MInvResultSchema();
			tMInvResultSchema.setSchema(mResultSet, 1);
			tMInvResultSet.add(tMInvResultSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMInvResultSchema = new MInvResultSchema();
					tMInvResultSchema.setSchema(mResultSet, 1);
					tMInvResultSet.add(tMInvResultSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "getData";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				mResultSet.close();
				mResultSet = null;
			}
			catch (Exception exception) { }
			try
			{
				mStatement.close();
				mStatement = null;
			}
			catch (Exception exception1) { }
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception exception2) { }
			return null;
		}
		return tMInvResultSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MInvResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了！";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mResultSet.close();
				mResultSet = null;
			}
		}
		catch (Exception ex2)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex2.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		try
		{
			if (mStatement == null)
			{
				CError tError = new CError();
				tError.moduleName = "MInvResultDB";
				tError.functionName = "closeData";
				tError.errorMessage = "语句已经关闭了！";
				mErrors.addOneError(tError);
				flag = false;
			} else
			{
				mStatement.close();
				mStatement = null;
			}
		}
		catch (Exception ex3)
		{
			CError tError = new CError();
			tError.moduleName = "MInvResultDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
