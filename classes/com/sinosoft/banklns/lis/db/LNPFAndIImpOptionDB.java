// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPFAndIImpOptionDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPFAndIImpOptionSchema;
import com.sinosoft.banklns.lis.vschema.LNPFAndIImpOptionSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPFAndIImpOptionDB extends LNPFAndIImpOptionSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPFAndIImpOptionDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPFAndIImpOption");
		mflag = true;
	}

	public LNPFAndIImpOptionDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPFAndIImpOption");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPFAndIImpOptionSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPFAndIImpOptionSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPFAndIImpOption WHERE  OptionId = ?");
			if (getOptionId() == null || getOptionId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getOptionId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			pstmt = con.prepareStatement("UPDATE LNPFAndIImpOption SET  ImpartId = ? , QuestionId = ? , OptionId = ? , OptionOrder = ? , OptionContent = ? , Operator = ? , ManageCom = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  OptionId = ?");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getQuestionId() == null || getQuestionId().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getQuestionId());
			if (getOptionId() == null || getOptionId().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getOptionId());
			if (getOptionOrder() == null || getOptionOrder().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOptionOrder());
			if (getOptionContent() == null || getOptionContent().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOptionContent());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(8, 91);
			else
				pstmt.setDate(8, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getModifyTime());
			if (getOptionId() == null || getOptionId().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getOptionId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPFAndIImpOption VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getImpartId() == null || getImpartId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getImpartId());
			if (getQuestionId() == null || getQuestionId().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getQuestionId());
			if (getOptionId() == null || getOptionId().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getOptionId());
			if (getOptionOrder() == null || getOptionOrder().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOptionOrder());
			if (getOptionContent() == null || getOptionContent().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getOptionContent());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getOperator());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getManageCom());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(8, 91);
			else
				pstmt.setDate(8, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPFAndIImpOption WHERE  OptionId = ?", 1003, 1007);
		if (getOptionId() == null || getOptionId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getOptionId());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "LNPFAndIImpOptionDB";
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
				tError.moduleName = "LNPFAndIImpOptionDB";
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

	public LNPFAndIImpOptionSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPFAndIImpOption");
			LNPFAndIImpOptionSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPFAndIImpOptionSchema s1;
			for (; rs.next(); aLNPFAndIImpOptionSet.add(s1))
			{
				i++;
				s1 = new LNPFAndIImpOptionSchema();
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		return aLNPFAndIImpOptionSet;
	}

	public LNPFAndIImpOptionSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPFAndIImpOptionSchema s1;
			for (; rs.next(); aLNPFAndIImpOptionSet.add(s1))
			{
				i++;
				s1 = new LNPFAndIImpOptionSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		return aLNPFAndIImpOptionSet;
	}

	public LNPFAndIImpOptionSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPFAndIImpOption");
			LNPFAndIImpOptionSchema aSchema = getSchema();
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
				LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
				s1.setSchema(rs, i);
				aLNPFAndIImpOptionSet.add(s1);
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		return aLNPFAndIImpOptionSet;
	}

	public LNPFAndIImpOptionSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPFAndIImpOptionSet aLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
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
				LNPFAndIImpOptionSchema s1 = new LNPFAndIImpOptionSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPFAndIImpOptionDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPFAndIImpOptionSet.add(s1);
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		return aLNPFAndIImpOptionSet;
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
				SQLString sqlObj = new SQLString("LNPFAndIImpOption");
				LNPFAndIImpOptionSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPFAndIImpOption ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpOptionDB";
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
				tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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

	public LNPFAndIImpOptionSet getData()
	{
		int tCount = 0;
		LNPFAndIImpOptionSet tLNPFAndIImpOptionSet = new LNPFAndIImpOptionSet();
		LNPFAndIImpOptionSchema tLNPFAndIImpOptionSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPFAndIImpOptionSchema = new LNPFAndIImpOptionSchema();
			tLNPFAndIImpOptionSchema.setSchema(mResultSet, 1);
			tLNPFAndIImpOptionSet.add(tLNPFAndIImpOptionSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPFAndIImpOptionSchema = new LNPFAndIImpOptionSchema();
					tLNPFAndIImpOptionSchema.setSchema(mResultSet, 1);
					tLNPFAndIImpOptionSet.add(tLNPFAndIImpOptionSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPFAndIImpOptionDB";
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
		return tLNPFAndIImpOptionSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPFAndIImpOptionDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了�?";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
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
				tError.moduleName = "LNPFAndIImpOptionDB";
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
			tError.moduleName = "LNPFAndIImpOptionDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
