// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MCourseDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MCourseSchema;
import com.sinosoft.map.lis.vschema.MCourseSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MCourseDB extends MCourseSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MCourseDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MCourse");
		mflag = true;
	}

	public MCourseDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MCourse");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MCourseSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MCourseSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
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
			pstmt = con.prepareStatement("DELETE FROM MCourse WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
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
			pstmt = con.prepareStatement("UPDATE MCourse SET  ID = ? , CourseID = ? , CourseName = ? , ManageCom = ? , BranchType = ? , Hour = ? , DevelopBranch = ? , Developer = ? , DevelopeDate = ? , NoTi = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , course1 = ? , course2 = ? , course3 = ? , course4 = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getCourseID() == null || getCourseID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCourseID());
			if (getCourseName() == null || getCourseName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCourseName());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchType());
			if (getHour() == null || getHour().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getHour());
			if (getDevelopBranch() == null || getDevelopBranch().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getDevelopBranch());
			if (getDeveloper() == null || getDeveloper().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDeveloper());
			if (getNoTi() == null || getNoTi().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getNoTi());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getModifyOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getModifyTime());
			if (getCourse1() == null || getCourse1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCourse1());
			if (getCourse2() == null || getCourse2().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getCourse2());
			if (getCourse3() == null || getCourse3().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCourse3());
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
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
			pstmt = con.prepareStatement("INSERT INTO MCourse VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getCourseID() == null || getCourseID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCourseID());
			if (getCourseName() == null || getCourseName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCourseName());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchType());
			if (getHour() == null || getHour().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getHour());
			if (getDevelopBranch() == null || getDevelopBranch().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getDevelopBranch());
			if (getDeveloper() == null || getDeveloper().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDeveloper());
			if (getNoTi() == null || getNoTi().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getNoTi());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getModifyOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getModifyTime());
			if (getCourse1() == null || getCourse1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCourse1());
			if (getCourse2() == null || getCourse2().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getCourse2());
			if (getCourse3() == null || getCourse3().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCourse3());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MCourse WHERE  ID = ?", 1003, 1007);
		if (getID() == null || getID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "MCourseDB";
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
				tError.moduleName = "MCourseDB";
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

	public MCourseSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MCourseSet aMCourseSet = new MCourseSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MCourse");
			MCourseSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MCourseSchema s1;
			for (; rs.next(); aMCourseSet.add(s1))
			{
				i++;
				s1 = new MCourseSchema();
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
			tError.moduleName = "MCourseDB";
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
		return aMCourseSet;
	}

	public MCourseSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MCourseSet aMCourseSet = new MCourseSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MCourseSchema s1;
			for (; rs.next(); aMCourseSet.add(s1))
			{
				i++;
				s1 = new MCourseSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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
		return aMCourseSet;
	}

	public MCourseSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MCourseSet aMCourseSet = new MCourseSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MCourse");
			MCourseSchema aSchema = getSchema();
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
				MCourseSchema s1 = new MCourseSchema();
				s1.setSchema(rs, i);
				aMCourseSet.add(s1);
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
			tError.moduleName = "MCourseDB";
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
		return aMCourseSet;
	}

	public MCourseSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MCourseSet aMCourseSet = new MCourseSet();
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
				MCourseSchema s1 = new MCourseSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MCourseDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMCourseSet.add(s1);
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
			tError.moduleName = "MCourseDB";
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
		return aMCourseSet;
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
				SQLString sqlObj = new SQLString("MCourse");
				MCourseSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MCourse ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MCourseDB";
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
				tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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

	public MCourseSet getData()
	{
		int tCount = 0;
		MCourseSet tMCourseSet = new MCourseSet();
		MCourseSchema tMCourseSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMCourseSchema = new MCourseSchema();
			tMCourseSchema.setSchema(mResultSet, 1);
			tMCourseSet.add(tMCourseSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMCourseSchema = new MCourseSchema();
					tMCourseSchema.setSchema(mResultSet, 1);
					tMCourseSet.add(tMCourseSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MCourseDB";
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
		return tMCourseSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
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
				tError.moduleName = "MCourseDB";
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
			tError.moduleName = "MCourseDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
