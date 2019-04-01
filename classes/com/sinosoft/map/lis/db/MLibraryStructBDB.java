// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryStructBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MLibraryStructBSchema;
import com.sinosoft.map.lis.vschema.MLibraryStructBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLibraryStructBDB extends MLibraryStructBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MLibraryStructBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MLibraryStructB");
		mflag = true;
	}

	public MLibraryStructBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MLibraryStructB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MLibraryStructBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MLibraryStructBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MLibraryStructB WHERE  EdorNo = ?");
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
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
			pstmt = con.prepareStatement("UPDATE MLibraryStructB SET  NodeID = ? , Name = ? , ParentID = ? , Discription = ? , ManageCom = ? , BranchType = ? , Position = ? , Operation = ? , DirFlag = ? , FileFlag = ? , ChildDirNum = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
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
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getMakeTime2());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MLibraryStructB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getMakeTime2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MLibraryStructB WHERE  EdorNo = ?", 1003, 1007);
		if (getEdorNo() == null || getEdorNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getEdorNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "MLibraryStructBDB";
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
				tError.moduleName = "MLibraryStructBDB";
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

	public MLibraryStructBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryStructB");
			MLibraryStructBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MLibraryStructBSchema s1;
			for (; rs.next(); aMLibraryStructBSet.add(s1))
			{
				i++;
				s1 = new MLibraryStructBSchema();
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
			tError.moduleName = "MLibraryStructBDB";
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
		return aMLibraryStructBSet;
	}

	public MLibraryStructBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MLibraryStructBSchema s1;
			for (; rs.next(); aMLibraryStructBSet.add(s1))
			{
				i++;
				s1 = new MLibraryStructBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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
		return aMLibraryStructBSet;
	}

	public MLibraryStructBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryStructB");
			MLibraryStructBSchema aSchema = getSchema();
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
				MLibraryStructBSchema s1 = new MLibraryStructBSchema();
				s1.setSchema(rs, i);
				aMLibraryStructBSet.add(s1);
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
			tError.moduleName = "MLibraryStructBDB";
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
		return aMLibraryStructBSet;
	}

	public MLibraryStructBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryStructBSet aMLibraryStructBSet = new MLibraryStructBSet();
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
				MLibraryStructBSchema s1 = new MLibraryStructBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryStructBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMLibraryStructBSet.add(s1);
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
			tError.moduleName = "MLibraryStructBDB";
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
		return aMLibraryStructBSet;
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
				SQLString sqlObj = new SQLString("MLibraryStructB");
				MLibraryStructBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MLibraryStructB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MLibraryStructBDB";
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
				tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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

	public MLibraryStructBSet getData()
	{
		int tCount = 0;
		MLibraryStructBSet tMLibraryStructBSet = new MLibraryStructBSet();
		MLibraryStructBSchema tMLibraryStructBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMLibraryStructBSchema = new MLibraryStructBSchema();
			tMLibraryStructBSchema.setSchema(mResultSet, 1);
			tMLibraryStructBSet.add(tMLibraryStructBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMLibraryStructBSchema = new MLibraryStructBSchema();
					tMLibraryStructBSchema.setSchema(mResultSet, 1);
					tMLibraryStructBSet.add(tMLibraryStructBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryStructBDB";
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
		return tMLibraryStructBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
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
				tError.moduleName = "MLibraryStructBDB";
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
			tError.moduleName = "MLibraryStructBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
