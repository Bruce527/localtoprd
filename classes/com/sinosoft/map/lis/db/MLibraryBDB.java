// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLibraryBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MLibraryBSchema;
import com.sinosoft.map.lis.vschema.MLibraryBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLibraryBDB extends MLibraryBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MLibraryBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MLibraryB");
		mflag = true;
	}

	public MLibraryBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MLibraryB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MLibraryBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MLibraryBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MLibraryB WHERE  EdorNo = ?");
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
			tError.moduleName = "MLibraryBDB";
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
			pstmt = con.prepareStatement("UPDATE MLibraryB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , FileID = ? , Name = ? , DisplayName = ? , FileDescription = ? , ManageCom = ? , BranchType = ? , NodeID = ? , FileType = ? , FilePath = ? , DocumentType = ? , StartDisplayDate = ? , EndDisplayDate = ? , MinDisplayGrade = ? , StartDisplayTime = ? , EndDisplayTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , State = ? WHERE  EdorNo = ?");
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(5, 91);
			else
				pstmt.setDate(5, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMakeTime2());
			if (getFileID() == null || getFileID().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFileID());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getName());
			if (getDisplayName() == null || getDisplayName().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getDisplayName());
			if (getFileDescription() == null || getFileDescription().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getFileDescription());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getBranchType());
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getNodeID());
			if (getFileType() == null || getFileType().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getFileType());
			if (getFilePath() == null || getFilePath().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getFilePath());
			if (getDocumentType() == null || getDocumentType().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getDocumentType());
			if (getStartDisplayDate() == null || getStartDisplayDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getStartDisplayDate()));
			if (getEndDisplayDate() == null || getEndDisplayDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getEndDisplayDate()));
			if (getMinDisplayGrade() == null || getMinDisplayGrade().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMinDisplayGrade());
			if (getStartDisplayTime() == null || getStartDisplayTime().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getStartDisplayTime());
			if (getEndDisplayTime() == null || getEndDisplayTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getEndDisplayTime());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getNF01());
			pstmt.setInt(29, getIF01());
			pstmt.setDouble(30, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(36, 91);
			else
				pstmt.setDate(36, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getModifyTime());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getState());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MLibraryB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(5, 91);
			else
				pstmt.setDate(5, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMakeTime2());
			if (getFileID() == null || getFileID().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFileID());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getName());
			if (getDisplayName() == null || getDisplayName().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getDisplayName());
			if (getFileDescription() == null || getFileDescription().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getFileDescription());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getBranchType());
			if (getNodeID() == null || getNodeID().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getNodeID());
			if (getFileType() == null || getFileType().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getFileType());
			if (getFilePath() == null || getFilePath().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getFilePath());
			if (getDocumentType() == null || getDocumentType().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getDocumentType());
			if (getStartDisplayDate() == null || getStartDisplayDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getStartDisplayDate()));
			if (getEndDisplayDate() == null || getEndDisplayDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getEndDisplayDate()));
			if (getMinDisplayGrade() == null || getMinDisplayGrade().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMinDisplayGrade());
			if (getStartDisplayTime() == null || getStartDisplayTime().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getStartDisplayTime());
			if (getEndDisplayTime() == null || getEndDisplayTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getEndDisplayTime());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getNF01());
			pstmt.setInt(29, getIF01());
			pstmt.setDouble(30, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(31, 91);
			else
				pstmt.setDate(31, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(36, 91);
			else
				pstmt.setDate(36, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getModifyTime());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getState());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MLibraryB WHERE  EdorNo = ?", 1003, 1007);
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
		tError.moduleName = "MLibraryBDB";
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
				tError.moduleName = "MLibraryBDB";
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

	public MLibraryBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryBSet aMLibraryBSet = new MLibraryBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryB");
			MLibraryBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MLibraryBSchema s1;
			for (; rs.next(); aMLibraryBSet.add(s1))
			{
				i++;
				s1 = new MLibraryBSchema();
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
			tError.moduleName = "MLibraryBDB";
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
		return aMLibraryBSet;
	}

	public MLibraryBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryBSet aMLibraryBSet = new MLibraryBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MLibraryBSchema s1;
			for (; rs.next(); aMLibraryBSet.add(s1))
			{
				i++;
				s1 = new MLibraryBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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
		return aMLibraryBSet;
	}

	public MLibraryBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryBSet aMLibraryBSet = new MLibraryBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLibraryB");
			MLibraryBSchema aSchema = getSchema();
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
				MLibraryBSchema s1 = new MLibraryBSchema();
				s1.setSchema(rs, i);
				aMLibraryBSet.add(s1);
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
			tError.moduleName = "MLibraryBDB";
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
		return aMLibraryBSet;
	}

	public MLibraryBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLibraryBSet aMLibraryBSet = new MLibraryBSet();
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
				MLibraryBSchema s1 = new MLibraryBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLibraryBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMLibraryBSet.add(s1);
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
			tError.moduleName = "MLibraryBDB";
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
		return aMLibraryBSet;
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
				SQLString sqlObj = new SQLString("MLibraryB");
				MLibraryBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MLibraryB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MLibraryBDB";
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
				tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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

	public MLibraryBSet getData()
	{
		int tCount = 0;
		MLibraryBSet tMLibraryBSet = new MLibraryBSet();
		MLibraryBSchema tMLibraryBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMLibraryBSchema = new MLibraryBSchema();
			tMLibraryBSchema.setSchema(mResultSet, 1);
			tMLibraryBSet.add(tMLibraryBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMLibraryBSchema = new MLibraryBSchema();
					tMLibraryBSchema.setSchema(mResultSet, 1);
					tMLibraryBSet.add(tMLibraryBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLibraryBDB";
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
		return tMLibraryBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
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
				tError.moduleName = "MLibraryBDB";
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
			tError.moduleName = "MLibraryBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
