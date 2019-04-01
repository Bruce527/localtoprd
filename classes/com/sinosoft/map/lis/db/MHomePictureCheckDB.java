// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MHomePictureCheckDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MHomePictureCheckSchema;
import com.sinosoft.map.lis.vschema.MHomePictureCheckSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MHomePictureCheckDB extends MHomePictureCheckSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MHomePictureCheckDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MHomePictureCheck");
		mflag = true;
	}

	public MHomePictureCheckDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MHomePictureCheck");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MHomePictureCheckSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MHomePictureCheckSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
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
			pstmt = con.prepareStatement("DELETE FROM MHomePictureCheck WHERE  ID = ?");
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
			tError.moduleName = "MHomePictureCheckDB";
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
			pstmt = con.prepareStatement("UPDATE MHomePictureCheck SET  ID = ? , URL = ? , RefURL = ? , Name = ? , Alt = ? , PicOrder = ? , DisplayFlag = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getURL() == null || getURL().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getURL());
			if (getRefURL() == null || getRefURL().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRefURL());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getName());
			if (getAlt() == null || getAlt().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getAlt());
			pstmt.setInt(6, getPicOrder());
			if (getDisplayFlag() == null || getDisplayFlag().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getDisplayFlag());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getNF01());
			pstmt.setInt(15, getIF01());
			pstmt.setDouble(16, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getModifyTime());
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
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
			pstmt = con.prepareStatement("INSERT INTO MHomePictureCheck VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getURL() == null || getURL().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getURL());
			if (getRefURL() == null || getRefURL().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRefURL());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getName());
			if (getAlt() == null || getAlt().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getAlt());
			pstmt.setInt(6, getPicOrder());
			if (getDisplayFlag() == null || getDisplayFlag().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getDisplayFlag());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getNF01());
			pstmt.setInt(15, getIF01());
			pstmt.setDouble(16, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MHomePictureCheck WHERE  ID = ?", 1003, 1007);
		if (getID() == null || getID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_194;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_194;
		CError tError = new CError();
		tError.moduleName = "MHomePictureCheckDB";
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
				tError.moduleName = "MHomePictureCheckDB";
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

	public MHomePictureCheckSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MHomePictureCheck");
			MHomePictureCheckSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MHomePictureCheckSchema s1;
			for (; rs.next(); aMHomePictureCheckSet.add(s1))
			{
				i++;
				s1 = new MHomePictureCheckSchema();
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
			tError.moduleName = "MHomePictureCheckDB";
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
		return aMHomePictureCheckSet;
	}

	public MHomePictureCheckSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MHomePictureCheckSchema s1;
			for (; rs.next(); aMHomePictureCheckSet.add(s1))
			{
				i++;
				s1 = new MHomePictureCheckSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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
		return aMHomePictureCheckSet;
	}

	public MHomePictureCheckSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MHomePictureCheck");
			MHomePictureCheckSchema aSchema = getSchema();
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
				MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
				s1.setSchema(rs, i);
				aMHomePictureCheckSet.add(s1);
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
			tError.moduleName = "MHomePictureCheckDB";
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
		return aMHomePictureCheckSet;
	}

	public MHomePictureCheckSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MHomePictureCheckSet aMHomePictureCheckSet = new MHomePictureCheckSet();
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
				MHomePictureCheckSchema s1 = new MHomePictureCheckSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MHomePictureCheckDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMHomePictureCheckSet.add(s1);
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
			tError.moduleName = "MHomePictureCheckDB";
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
		return aMHomePictureCheckSet;
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
				SQLString sqlObj = new SQLString("MHomePictureCheck");
				MHomePictureCheckSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MHomePictureCheck ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MHomePictureCheckDB";
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
				tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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

	public MHomePictureCheckSet getData()
	{
		int tCount = 0;
		MHomePictureCheckSet tMHomePictureCheckSet = new MHomePictureCheckSet();
		MHomePictureCheckSchema tMHomePictureCheckSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMHomePictureCheckSchema = new MHomePictureCheckSchema();
			tMHomePictureCheckSchema.setSchema(mResultSet, 1);
			tMHomePictureCheckSet.add(tMHomePictureCheckSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMHomePictureCheckSchema = new MHomePictureCheckSchema();
					tMHomePictureCheckSchema.setSchema(mResultSet, 1);
					tMHomePictureCheckSet.add(tMHomePictureCheckSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MHomePictureCheckDB";
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
		return tMHomePictureCheckSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
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
				tError.moduleName = "MHomePictureCheckDB";
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
			tError.moduleName = "MHomePictureCheckDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
