// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MPublicMessageBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MPublicMessageBSchema;
import com.sinosoft.map.lis.vschema.MPublicMessageBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MPublicMessageBDB extends MPublicMessageBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MPublicMessageBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MPublicMessageB");
		mflag = true;
	}

	public MPublicMessageBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MPublicMessageB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MPublicMessageBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MPublicMessageBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "getCount";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM MPublicMessageB WHERE  EdorNo = ?");
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
			tError.moduleName = "MPublicMessageBDB";
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
			pstmt = con.prepareStatement("UPDATE MPublicMessageB SET  EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? , ID = ? , ReceiveBranch = ? , ManageCom = ? , BranchType = ? , Message = ? , Type = ? , Author = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? WHERE  EdorNo = ?");
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
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getID());
			if (getReceiveBranch() == null || getReceiveBranch().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getReceiveBranch());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBranchType());
			if (getMessage() == null || getMessage().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMessage());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getType());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAuthor());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getState());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getEndDate()));
			if (getStartTime() == null || getStartTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getStartTime());
			if (getEndTime() == null || getEndTime().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getEndTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getNF01());
			pstmt.setInt(21, getIF01());
			pstmt.setDouble(22, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getDate01()));
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getModifyOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getModifyTime());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getCheckTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MPublicMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getID());
			if (getReceiveBranch() == null || getReceiveBranch().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getReceiveBranch());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBranchType());
			if (getMessage() == null || getMessage().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMessage());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getType());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAuthor());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getState());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getEndDate()));
			if (getStartTime() == null || getStartTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getStartTime());
			if (getEndTime() == null || getEndTime().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getEndTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getNF01());
			pstmt.setInt(21, getIF01());
			pstmt.setDouble(22, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getDate01()));
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getModifyOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getModifyTime());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getCheckTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MPublicMessageB WHERE  EdorNo = ?", 1003, 1007);
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
		tError.moduleName = "MPublicMessageBDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "ȡ��ʧ��!";
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
				tError.moduleName = "MPublicMessageBDB";
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

	public MPublicMessageBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MPublicMessageB");
			MPublicMessageBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MPublicMessageBSchema s1;
			for (; rs.next(); aMPublicMessageBSet.add(s1))
			{
				i++;
				s1 = new MPublicMessageBSchema();
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
			tError.moduleName = "MPublicMessageBDB";
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
		return aMPublicMessageBSet;
	}

	public MPublicMessageBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MPublicMessageBSchema s1;
			for (; rs.next(); aMPublicMessageBSet.add(s1))
			{
				i++;
				s1 = new MPublicMessageBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MPublicMessageBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
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
			tError.moduleName = "MPublicMessageBDB";
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
		return aMPublicMessageBSet;
	}

	public MPublicMessageBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MPublicMessageB");
			MPublicMessageBSchema aSchema = getSchema();
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
				MPublicMessageBSchema s1 = new MPublicMessageBSchema();
				s1.setSchema(rs, i);
				aMPublicMessageBSet.add(s1);
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
			tError.moduleName = "MPublicMessageBDB";
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
		return aMPublicMessageBSet;
	}

	public MPublicMessageBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MPublicMessageBSet aMPublicMessageBSet = new MPublicMessageBSet();
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
				MPublicMessageBSchema s1 = new MPublicMessageBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MPublicMessageBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aMPublicMessageBSet.add(s1);
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
			tError.moduleName = "MPublicMessageBDB";
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
		return aMPublicMessageBSet;
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
				SQLString sqlObj = new SQLString("MPublicMessageB");
				MPublicMessageBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MPublicMessageB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MPublicMessageBDB";
				tError.functionName = "update";
				tError.errorMessage = "�������ʧ��?!";
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
				tError.moduleName = "MPublicMessageBDB";
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
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "��ݼ��ǿգ�������׼����ݼ�֮��û�йرգ�";
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
			tError.moduleName = "MPublicMessageBDB";
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
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
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
			tError.moduleName = "MPublicMessageBDB";
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

	public MPublicMessageBSet getData()
	{
		int tCount = 0;
		MPublicMessageBSet tMPublicMessageBSet = new MPublicMessageBSet();
		MPublicMessageBSchema tMPublicMessageBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "getData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMPublicMessageBSchema = new MPublicMessageBSchema();
			tMPublicMessageBSchema.setSchema(mResultSet, 1);
			tMPublicMessageBSet.add(tMPublicMessageBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMPublicMessageBSchema = new MPublicMessageBSchema();
					tMPublicMessageBSchema.setSchema(mResultSet, 1);
					tMPublicMessageBSet.add(tMPublicMessageBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MPublicMessageBDB";
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
		return tMPublicMessageBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MPublicMessageBDB";
				tError.functionName = "closeData";
				tError.errorMessage = "��ݼ��Ѿ��ر��ˣ�?";
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
			tError.moduleName = "MPublicMessageBDB";
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
				tError.moduleName = "MPublicMessageBDB";
				tError.functionName = "closeData";
				tError.errorMessage = "����Ѿ��ر��ˣ�?";
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
			tError.moduleName = "MPublicMessageBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
