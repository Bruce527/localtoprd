// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MC2BMessageBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MC2BMessageBSchema;
import com.sinosoft.map.lis.vschema.MC2BMessageBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MC2BMessageBDB extends MC2BMessageBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MC2BMessageBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MC2BMessageB");
		mflag = true;
	}

	public MC2BMessageBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MC2BMessageB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MC2BMessageBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MC2BMessageBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MC2BMessageB WHERE  ID = ?");
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
			tError.moduleName = "MC2BMessageBDB";
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
			pstmt = con.prepareStatement("UPDATE MC2BMessageB SET  ID = ? , ManageCom = ? , BranchType = ? , Message = ? , MessageType = ? , KeyData = ? , KeyData2 = ? , KeyData3 = ? , KeyData4 = ? , URL = ? , Type = ? , State = ? , StartDate = ? , EndDate = ? , StartTime = ? , EndTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getBranchType());
			if (getMessage() == null || getMessage().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getMessage());
			if (getMessageType() == null || getMessageType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMessageType());
			if (getKeyData() == null || getKeyData().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getKeyData());
			if (getKeyData2() == null || getKeyData2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getKeyData2());
			if (getKeyData3() == null || getKeyData3().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getKeyData3());
			if (getKeyData4() == null || getKeyData4().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getKeyData4());
			if (getURL() == null || getURL().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getURL());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getState());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(13, 91);
			else
				pstmt.setDate(13, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getEndDate()));
			if (getStartTime() == null || getStartTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getStartTime());
			if (getEndTime() == null || getEndTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getEndTime());
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getMakeTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(29, 91);
			else
				pstmt.setDate(29, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getMakeTime2());
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MC2BMessageB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getBranchType());
			if (getMessage() == null || getMessage().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getMessage());
			if (getMessageType() == null || getMessageType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMessageType());
			if (getKeyData() == null || getKeyData().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getKeyData());
			if (getKeyData2() == null || getKeyData2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getKeyData2());
			if (getKeyData3() == null || getKeyData3().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getKeyData3());
			if (getKeyData4() == null || getKeyData4().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getKeyData4());
			if (getURL() == null || getURL().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getURL());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getState());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(13, 91);
			else
				pstmt.setDate(13, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getEndDate()));
			if (getStartTime() == null || getStartTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getStartTime());
			if (getEndTime() == null || getEndTime().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getEndTime());
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(23, 91);
			else
				pstmt.setDate(23, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getMakeTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(29, 91);
			else
				pstmt.setDate(29, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getMakeTime2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MC2BMessageB WHERE  ID = ?", 1003, 1007);
		if (getID() == null || getID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "MC2BMessageBDB";
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
				tError.moduleName = "MC2BMessageBDB";
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

	public MC2BMessageBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MC2BMessageB");
			MC2BMessageBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MC2BMessageBSchema s1;
			for (; rs.next(); aMC2BMessageBSet.add(s1))
			{
				i++;
				s1 = new MC2BMessageBSchema();
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
			tError.moduleName = "MC2BMessageBDB";
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
		return aMC2BMessageBSet;
	}

	public MC2BMessageBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MC2BMessageBSchema s1;
			for (; rs.next(); aMC2BMessageBSet.add(s1))
			{
				i++;
				s1 = new MC2BMessageBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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
		return aMC2BMessageBSet;
	}

	public MC2BMessageBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MC2BMessageB");
			MC2BMessageBSchema aSchema = getSchema();
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
				MC2BMessageBSchema s1 = new MC2BMessageBSchema();
				s1.setSchema(rs, i);
				aMC2BMessageBSet.add(s1);
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
			tError.moduleName = "MC2BMessageBDB";
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
		return aMC2BMessageBSet;
	}

	public MC2BMessageBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MC2BMessageBSet aMC2BMessageBSet = new MC2BMessageBSet();
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
				MC2BMessageBSchema s1 = new MC2BMessageBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MC2BMessageBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMC2BMessageBSet.add(s1);
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
			tError.moduleName = "MC2BMessageBDB";
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
		return aMC2BMessageBSet;
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
				SQLString sqlObj = new SQLString("MC2BMessageB");
				MC2BMessageBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MC2BMessageB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MC2BMessageBDB";
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
				tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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

	public MC2BMessageBSet getData()
	{
		int tCount = 0;
		MC2BMessageBSet tMC2BMessageBSet = new MC2BMessageBSet();
		MC2BMessageBSchema tMC2BMessageBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMC2BMessageBSchema = new MC2BMessageBSchema();
			tMC2BMessageBSchema.setSchema(mResultSet, 1);
			tMC2BMessageBSet.add(tMC2BMessageBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMC2BMessageBSchema = new MC2BMessageBSchema();
					tMC2BMessageBSchema.setSchema(mResultSet, 1);
					tMC2BMessageBSet.add(tMC2BMessageBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MC2BMessageBDB";
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
		return tMC2BMessageBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
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
				tError.moduleName = "MC2BMessageBDB";
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
			tError.moduleName = "MC2BMessageBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
