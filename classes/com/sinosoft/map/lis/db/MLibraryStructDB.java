// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryStructDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MLibraryStructSchema;
import com.sinosoft.map.lis.vschema.MLibraryStructSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLibraryStructDB extends MLibraryStructSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MLibraryStructDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MLibraryStruct");
		mflag = true;
	}

	public MLibraryStructDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MLibraryStruct");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MLibraryStructSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MLibraryStructSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
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
			pstmt = con.prepareStatement("DELETE FROM MLibraryStruct WHERE  NodeID = ?");
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNodeID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
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
			pstmt = con.prepareStatement("UPDATE MLibraryStruct SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  NodeID = ?");
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNodeID());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getName());
			if (getParentID() == null || getParentID().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getParentID());
			if (getDiscription() == null || getDiscription().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getDiscription());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBranchType());
			pstmt.setInt(7, getPosition());
			if (getOperation() == null || getOperation().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOperation());
			if (getDirFlag() == null || getDirFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getDirFlag());
			if (getFileFlag() == null || getFileFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getFileFlag());
			pstmt.setInt(11, getChildDirNum());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getNF01());
			pstmt.setInt(19, getIF01());
			pstmt.setDouble(20, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getModifyTime());
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getNodeID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
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
			pstmt = con.prepareStatement("INSERT INTO MLibraryStruct VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNodeID());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getName());
			if (getParentID() == null || getParentID().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getParentID());
			if (getDiscription() == null || getDiscription().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getDiscription());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBranchType());
			pstmt.setInt(7, getPosition());
			if (getOperation() == null || getOperation().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOperation());
			if (getDirFlag() == null || getDirFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getDirFlag());
			if (getFileFlag() == null || getFileFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getFileFlag());
			pstmt.setInt(11, getChildDirNum());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getNF01());
			pstmt.setInt(19, getIF01());
			pstmt.setDouble(20, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(21, 91);
			else
				pstmt.setDate(21, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MLibraryStruct WHERE  NodeID = ?", 1003, 1007);
		if (getNodeID() == null || getNodeID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getNodeID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "MLibraryStructDB";
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
				tError.moduleName = "MLibraryStructDB";
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

	public MLibraryStructSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryStruct");
			MLibraryStructSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MLibraryStructSchema s1;
			for (; rs.next(); aMLibraryStructSet.add(s1))
			{
				i++;
				s1 = new MLibraryStructSchema();
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
			tError.moduleName = "MLibraryStructDB";
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
		return aMLibraryStructSet;
	}

	public MLibraryStructSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MLibraryStructSchema s1;
			for (; rs.next(); aMLibraryStructSet.add(s1))
			{
				i++;
				s1 = new MLibraryStructSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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
		return aMLibraryStructSet;
	}

	public MLibraryStructSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryStruct");
			MLibraryStructSchema aSchema = getSchema();
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
				MLibraryStructSchema s1 = new MLibraryStructSchema();
				s1.setSchema(rs, i);
				aMLibraryStructSet.add(s1);
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
			tError.moduleName = "MLibraryStructDB";
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
		return aMLibraryStructSet;
	}

	public MLibraryStructSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructSet aMLibraryStructSet = new MLibraryStructSet();
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
				MLibraryStructSchema s1 = new MLibraryStructSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryStructDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMLibraryStructSet.add(s1);
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
			tError.moduleName = "MLibraryStructDB";
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
		return aMLibraryStructSet;
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
				SQLString sqlObj = new SQLString("MLibraryStruct");
				MLibraryStructSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MLibraryStruct ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MLibraryStructDB";
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
				tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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

	public MLibraryStructSet getData()
	{
		int tCount = 0;
		MLibraryStructSet tMLibraryStructSet = new MLibraryStructSet();
		MLibraryStructSchema tMLibraryStructSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMLibraryStructSchema = new MLibraryStructSchema();
			tMLibraryStructSchema.setSchema(mResultSet, 1);
			tMLibraryStructSet.add(tMLibraryStructSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMLibraryStructSchema = new MLibraryStructSchema();
					tMLibraryStructSchema.setSchema(mResultSet, 1);
					tMLibraryStructSet.add(tMLibraryStructSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryStructDB";
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
		return tMLibraryStructSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
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
				tError.moduleName = "MLibraryStructDB";
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
			tError.moduleName = "MLibraryStructDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
