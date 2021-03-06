// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMessageConfigDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MMessageConfigSchema;
import com.sinosoft.map.lis.vschema.MMessageConfigSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MMessageConfigDB extends MMessageConfigSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MMessageConfigDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MMessageConfig");
		mflag = true;
	}

	public MMessageConfigDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MMessageConfig");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MMessageConfigSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MMessageConfigSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
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
			pstmt = con.prepareStatement("DELETE FROM MMessageConfig WHERE  ID = ?");
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
			tError.moduleName = "MMessageConfigDB";
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
			pstmt = con.prepareStatement("UPDATE MMessageConfig SET  ID = ? , ManageCom = ? , BranchType = ? , MessageType = ? , MessageName = ? , MessageContent = ? , MessageContent2 = ? , MessageContent3 = ? , MessageContent4 = ? , MessageContent5 = ? , MessageContent6 = ? , BeforeDays = ? , StatDays = ? , StartDate = ? , EndDate = ? , StatCycle = ? , Script = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , Operator = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
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
			if (getMessageType() == null || getMessageType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getMessageType());
			if (getMessageName() == null || getMessageName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMessageName());
			if (getMessageContent() == null || getMessageContent().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMessageContent());
			if (getMessageContent2() == null || getMessageContent2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getMessageContent2());
			if (getMessageContent3() == null || getMessageContent3().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getMessageContent3());
			if (getMessageContent4() == null || getMessageContent4().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMessageContent4());
			if (getMessageContent5() == null || getMessageContent5().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getMessageContent5());
			if (getMessageContent6() == null || getMessageContent6().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMessageContent6());
			pstmt.setInt(12, getBeforeDays());
			pstmt.setInt(13, getStatDays());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getEndDate()));
			if (getStatCycle() == null || getStatCycle().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getStatCycle());
			if (getScript() == null || getScript().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getScript());
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
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
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
			pstmt = con.prepareStatement("INSERT INTO MMessageConfig VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getMessageType() == null || getMessageType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getMessageType());
			if (getMessageName() == null || getMessageName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMessageName());
			if (getMessageContent() == null || getMessageContent().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMessageContent());
			if (getMessageContent2() == null || getMessageContent2().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getMessageContent2());
			if (getMessageContent3() == null || getMessageContent3().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getMessageContent3());
			if (getMessageContent4() == null || getMessageContent4().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMessageContent4());
			if (getMessageContent5() == null || getMessageContent5().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getMessageContent5());
			if (getMessageContent6() == null || getMessageContent6().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMessageContent6());
			pstmt.setInt(12, getBeforeDays());
			pstmt.setInt(13, getStatDays());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getEndDate()));
			if (getStatCycle() == null || getStatCycle().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getStatCycle());
			if (getScript() == null || getScript().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getScript());
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
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MMessageConfig WHERE  ID = ?", 1003, 1007);
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
		tError.moduleName = "MMessageConfigDB";
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
				tError.moduleName = "MMessageConfigDB";
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

	public MMessageConfigSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MMessageConfig");
			MMessageConfigSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MMessageConfigSchema s1;
			for (; rs.next(); aMMessageConfigSet.add(s1))
			{
				i++;
				s1 = new MMessageConfigSchema();
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
			tError.moduleName = "MMessageConfigDB";
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
		return aMMessageConfigSet;
	}

	public MMessageConfigSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MMessageConfigSchema s1;
			for (; rs.next(); aMMessageConfigSet.add(s1))
			{
				i++;
				s1 = new MMessageConfigSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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
		return aMMessageConfigSet;
	}

	public MMessageConfigSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MMessageConfig");
			MMessageConfigSchema aSchema = getSchema();
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
				MMessageConfigSchema s1 = new MMessageConfigSchema();
				s1.setSchema(rs, i);
				aMMessageConfigSet.add(s1);
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
			tError.moduleName = "MMessageConfigDB";
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
		return aMMessageConfigSet;
	}

	public MMessageConfigSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMessageConfigSet aMMessageConfigSet = new MMessageConfigSet();
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
				MMessageConfigSchema s1 = new MMessageConfigSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MMessageConfigDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMMessageConfigSet.add(s1);
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
			tError.moduleName = "MMessageConfigDB";
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
		return aMMessageConfigSet;
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
				SQLString sqlObj = new SQLString("MMessageConfig");
				MMessageConfigSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MMessageConfig ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MMessageConfigDB";
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
				tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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

	public MMessageConfigSet getData()
	{
		int tCount = 0;
		MMessageConfigSet tMMessageConfigSet = new MMessageConfigSet();
		MMessageConfigSchema tMMessageConfigSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMMessageConfigSchema = new MMessageConfigSchema();
			tMMessageConfigSchema.setSchema(mResultSet, 1);
			tMMessageConfigSet.add(tMMessageConfigSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMMessageConfigSchema = new MMessageConfigSchema();
					tMMessageConfigSchema.setSchema(mResultSet, 1);
					tMMessageConfigSet.add(tMMessageConfigSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMessageConfigDB";
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
		return tMMessageConfigSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
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
				tError.moduleName = "MMessageConfigDB";
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
			tError.moduleName = "MMessageConfigDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
