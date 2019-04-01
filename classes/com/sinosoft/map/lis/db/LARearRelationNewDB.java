// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LARearRelationNewDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.LARearRelationNewSchema;
import com.sinosoft.map.lis.vschema.LARearRelationNewSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class LARearRelationNewDB extends LARearRelationNewSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LARearRelationNewDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LARearRelationNew");
		mflag = true;
	}

	public LARearRelationNewDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LARearRelationNew");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LARearRelationNewSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LARearRelationNewSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
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
			pstmt = con.prepareStatement("DELETE FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getAgentCode());
			if (getRAgentCode() == null || getRAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRAgentCode());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getType());
			pstmt.setInt(4, getDeep());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getState());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
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
			pstmt = con.prepareStatement("UPDATE LARearRelationNew SET  ManageCom = ? , AgentCode = ? , AgentGrade = ? , AgentGroup = ? , SMAgentCode = ? , AMAgentCode = ? , RAgentCode = ? , AgentTitle = ? , RAgentGrade = ? , RAgentTitle = ? , RAgentGroup = ? , RBranchAttr = ? , Type = ? , Deep = ? , StartDate = ? , BreakDate = ? , PBreakDate = ? , BreakType = ? , State = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Operator = ? WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?");
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getManageCom());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentGrade());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getSMAgentCode() == null || getSMAgentCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getSMAgentCode());
			if (getAMAgentCode() == null || getAMAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAMAgentCode());
			if (getRAgentCode() == null || getRAgentCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRAgentCode());
			if (getAgentTitle() == null || getAgentTitle().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentTitle());
			if (getRAgentGrade() == null || getRAgentGrade().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getRAgentGrade());
			if (getRAgentTitle() == null || getRAgentTitle().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getRAgentTitle());
			if (getRAgentGroup() == null || getRAgentGroup().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRAgentGroup());
			if (getRBranchAttr() == null || getRBranchAttr().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getRBranchAttr());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getType());
			pstmt.setInt(14, getDeep());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getStartDate()));
			if (getBreakDate() == null || getBreakDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getBreakDate()));
			if (getPBreakDate() == null || getPBreakDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getPBreakDate()));
			if (getBreakType() == null || getBreakType().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getBreakType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getState());
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getAgentCode());
			if (getRAgentCode() == null || getRAgentCode().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getRAgentCode());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getType());
			pstmt.setInt(28, getDeep());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getState());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
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
			pstmt = con.prepareStatement("INSERT INTO LARearRelationNew VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getManageCom());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAgentCode());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentGrade());
			if (getAgentGroup() == null || getAgentGroup().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getAgentGroup());
			if (getSMAgentCode() == null || getSMAgentCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getSMAgentCode());
			if (getAMAgentCode() == null || getAMAgentCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getAMAgentCode());
			if (getRAgentCode() == null || getRAgentCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRAgentCode());
			if (getAgentTitle() == null || getAgentTitle().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentTitle());
			if (getRAgentGrade() == null || getRAgentGrade().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getRAgentGrade());
			if (getRAgentTitle() == null || getRAgentTitle().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getRAgentTitle());
			if (getRAgentGroup() == null || getRAgentGroup().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRAgentGroup());
			if (getRBranchAttr() == null || getRBranchAttr().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getRBranchAttr());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getType());
			pstmt.setInt(14, getDeep());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(15, 91);
			else
				pstmt.setDate(15, Date.valueOf(getStartDate()));
			if (getBreakDate() == null || getBreakDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getBreakDate()));
			if (getPBreakDate() == null || getPBreakDate().equals("null"))
				pstmt.setNull(17, 91);
			else
				pstmt.setDate(17, Date.valueOf(getPBreakDate()));
			if (getBreakType() == null || getBreakType().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getBreakType());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getState());
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
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getOperator());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LARearRelationNew WHERE  AgentCode = ? AND RAgentCode = ? AND Type = ? AND Deep = ? AND State = ?", 1003, 1007);
		if (getAgentCode() == null || getAgentCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getAgentCode());
		if (getRAgentCode() == null || getRAgentCode().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getRAgentCode());
		if (getType() == null || getType().equals("null"))
			pstmt.setNull(3, 12);
		else
			pstmt.setString(3, getType());
		pstmt.setInt(4, getDeep());
		if (getState() == null || getState().equals("null"))
			pstmt.setNull(5, 12);
		else
			pstmt.setString(5, getState());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_331;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_331;
		CError tError = new CError();
		tError.moduleName = "LARearRelationNewDB";
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
				tError.moduleName = "LARearRelationNewDB";
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

	public LARearRelationNewSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LARearRelationNew");
			LARearRelationNewSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LARearRelationNewSchema s1;
			for (; rs.next(); aLARearRelationNewSet.add(s1))
			{
				i++;
				s1 = new LARearRelationNewSchema();
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
			tError.moduleName = "LARearRelationNewDB";
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
		return aLARearRelationNewSet;
	}

	public LARearRelationNewSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LARearRelationNewSchema s1;
			for (; rs.next(); aLARearRelationNewSet.add(s1))
			{
				i++;
				s1 = new LARearRelationNewSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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
		return aLARearRelationNewSet;
	}

	public LARearRelationNewSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LARearRelationNew");
			LARearRelationNewSchema aSchema = getSchema();
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
				LARearRelationNewSchema s1 = new LARearRelationNewSchema();
				s1.setSchema(rs, i);
				aLARearRelationNewSet.add(s1);
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
			tError.moduleName = "LARearRelationNewDB";
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
		return aLARearRelationNewSet;
	}

	public LARearRelationNewSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LARearRelationNewSet aLARearRelationNewSet = new LARearRelationNewSet();
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
				LARearRelationNewSchema s1 = new LARearRelationNewSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LARearRelationNewDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLARearRelationNewSet.add(s1);
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
			tError.moduleName = "LARearRelationNewDB";
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
		return aLARearRelationNewSet;
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
				SQLString sqlObj = new SQLString("LARearRelationNew");
				LARearRelationNewSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LARearRelationNew ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LARearRelationNewDB";
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
				tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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

	public LARearRelationNewSet getData()
	{
		int tCount = 0;
		LARearRelationNewSet tLARearRelationNewSet = new LARearRelationNewSet();
		LARearRelationNewSchema tLARearRelationNewSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLARearRelationNewSchema = new LARearRelationNewSchema();
			tLARearRelationNewSchema.setSchema(mResultSet, 1);
			tLARearRelationNewSet.add(tLARearRelationNewSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLARearRelationNewSchema = new LARearRelationNewSchema();
					tLARearRelationNewSchema.setSchema(mResultSet, 1);
					tLARearRelationNewSet.add(tLARearRelationNewSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LARearRelationNewDB";
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
		return tLARearRelationNewSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
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
				tError.moduleName = "LARearRelationNewDB";
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
			tError.moduleName = "LARearRelationNewDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
