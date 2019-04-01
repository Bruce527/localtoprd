// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MInvTopicBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MInvTopicBSchema;
import com.sinosoft.map.lis.vschema.MInvTopicBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MInvTopicBDB extends MInvTopicBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MInvTopicBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MInvTopicB");
		mflag = true;
	}

	public MInvTopicBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MInvTopicB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MInvTopicBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvTopicBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MInvTopicBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvTopicBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MInvTopicB WHERE  EdorNo = ?");
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
			tError.moduleName = "MInvTopicBDB";
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
			pstmt = con.prepareStatement("UPDATE MInvTopicB SET  TopicID = ? , Topic = ? , ManageCom = ? , BranchType = ? , Depiction = ? , Author = ? , Population = ? , StartDate = ? , EndDate = ? , InvType = ? , State = ? , InvState = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			if (getTopicID() == null || getTopicID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getTopicID());
			if (getTopic() == null || getTopic().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getTopic());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getBranchType());
			if (getDepiction() == null || getDepiction().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getDepiction());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAuthor());
			pstmt.setInt(7, getPopulation());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(8, 91);
			else
				pstmt.setDate(8, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getEndDate()));
			if (getInvType() == null || getInvType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getInvType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getState());
			if (getInvState() == null || getInvState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getInvState());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getNF01());
			pstmt.setInt(20, getIF01());
			pstmt.setDouble(21, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getModifyTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getMakeTime2());
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
			tError.moduleName = "MInvTopicBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MInvTopicB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getTopicID() == null || getTopicID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getTopicID());
			if (getTopic() == null || getTopic().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getTopic());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getBranchType());
			if (getDepiction() == null || getDepiction().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getDepiction());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAuthor());
			pstmt.setInt(7, getPopulation());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(8, 91);
			else
				pstmt.setDate(8, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getEndDate()));
			if (getInvType() == null || getInvType().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getInvType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getState());
			if (getInvState() == null || getInvState().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getInvState());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getNF01());
			pstmt.setInt(20, getIF01());
			pstmt.setDouble(21, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(22, 91);
			else
				pstmt.setDate(22, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(25, 91);
			else
				pstmt.setDate(25, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getModifyTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getMakeTime2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MInvTopicBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MInvTopicB WHERE  EdorNo = ?", 1003, 1007);
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
		tError.moduleName = "MInvTopicBDB";
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
				tError.moduleName = "MInvTopicBDB";
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

	public MInvTopicBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MInvTopicB");
			MInvTopicBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MInvTopicBSchema s1;
			for (; rs.next(); aMInvTopicBSet.add(s1))
			{
				i++;
				s1 = new MInvTopicBSchema();
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
			tError.moduleName = "MInvTopicBDB";
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
		return aMInvTopicBSet;
	}

	public MInvTopicBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MInvTopicBSchema s1;
			for (; rs.next(); aMInvTopicBSet.add(s1))
			{
				i++;
				s1 = new MInvTopicBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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
		return aMInvTopicBSet;
	}

	public MInvTopicBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MInvTopicB");
			MInvTopicBSchema aSchema = getSchema();
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
				MInvTopicBSchema s1 = new MInvTopicBSchema();
				s1.setSchema(rs, i);
				aMInvTopicBSet.add(s1);
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
			tError.moduleName = "MInvTopicBDB";
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
		return aMInvTopicBSet;
	}

	public MInvTopicBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MInvTopicBSet aMInvTopicBSet = new MInvTopicBSet();
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
				MInvTopicBSchema s1 = new MInvTopicBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MInvTopicBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMInvTopicBSet.add(s1);
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
			tError.moduleName = "MInvTopicBDB";
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
		return aMInvTopicBSet;
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
				SQLString sqlObj = new SQLString("MInvTopicB");
				MInvTopicBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MInvTopicB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MInvTopicBDB";
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
				tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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

	public MInvTopicBSet getData()
	{
		int tCount = 0;
		MInvTopicBSet tMInvTopicBSet = new MInvTopicBSet();
		MInvTopicBSchema tMInvTopicBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MInvTopicBDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMInvTopicBSchema = new MInvTopicBSchema();
			tMInvTopicBSchema.setSchema(mResultSet, 1);
			tMInvTopicBSet.add(tMInvTopicBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMInvTopicBSchema = new MInvTopicBSchema();
					tMInvTopicBSchema.setSchema(mResultSet, 1);
					tMInvTopicBSet.add(tMInvTopicBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MInvTopicBDB";
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
		return tMInvTopicBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
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
				tError.moduleName = "MInvTopicBDB";
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
			tError.moduleName = "MInvTopicBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
