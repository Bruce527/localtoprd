// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPRiskSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskDB extends LNPRiskSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPRiskDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPRisk");
		mflag = true;
	}

	public LNPRiskDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPRisk");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPRiskSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPRiskSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRisk WHERE  RiskCode = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
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
			pstmt = con.prepareStatement("UPDATE LNPRisk SET  RiskCode = ? , RiskVer = ? , RiskName = ? , RiskShortName = ? , RiskEnName = ? , RiskEnShortName = ? , ChoDutyFlag = ? , CPayFlag = ? , GetFlag = ? , EdorFlag = ? , RnewFlag = ? , UWFlag = ? , RinsFlag = ? , InsuAccFlag = ? , DestRate = ? , OrigRiskCode = ? , SubRiskVer = ? , RiskStatName = ? WHERE  RiskCode = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getRiskName() == null || getRiskName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRiskName());
			if (getRiskShortName() == null || getRiskShortName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getRiskShortName());
			if (getRiskEnName() == null || getRiskEnName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getRiskEnName());
			if (getRiskEnShortName() == null || getRiskEnShortName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getRiskEnShortName());
			if (getChoDutyFlag() == null || getChoDutyFlag().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getChoDutyFlag());
			if (getCPayFlag() == null || getCPayFlag().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCPayFlag());
			if (getGetFlag() == null || getGetFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getGetFlag());
			if (getEdorFlag() == null || getEdorFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getEdorFlag());
			if (getRnewFlag() == null || getRnewFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRnewFlag());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getUWFlag());
			if (getRinsFlag() == null || getRinsFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRinsFlag());
			if (getInsuAccFlag() == null || getInsuAccFlag().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getInsuAccFlag());
			pstmt.setDouble(15, getDestRate());
			if (getOrigRiskCode() == null || getOrigRiskCode().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getOrigRiskCode());
			if (getSubRiskVer() == null || getSubRiskVer().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getSubRiskVer());
			if (getRiskStatName() == null || getRiskStatName().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRiskStatName());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getRiskCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRisk VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getRiskName() == null || getRiskName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getRiskName());
			if (getRiskShortName() == null || getRiskShortName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getRiskShortName());
			if (getRiskEnName() == null || getRiskEnName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getRiskEnName());
			if (getRiskEnShortName() == null || getRiskEnShortName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getRiskEnShortName());
			if (getChoDutyFlag() == null || getChoDutyFlag().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getChoDutyFlag());
			if (getCPayFlag() == null || getCPayFlag().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCPayFlag());
			if (getGetFlag() == null || getGetFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getGetFlag());
			if (getEdorFlag() == null || getEdorFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getEdorFlag());
			if (getRnewFlag() == null || getRnewFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getRnewFlag());
			if (getUWFlag() == null || getUWFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getUWFlag());
			if (getRinsFlag() == null || getRinsFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRinsFlag());
			if (getInsuAccFlag() == null || getInsuAccFlag().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getInsuAccFlag());
			pstmt.setDouble(15, getDestRate());
			if (getOrigRiskCode() == null || getOrigRiskCode().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getOrigRiskCode());
			if (getSubRiskVer() == null || getSubRiskVer().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getSubRiskVer());
			if (getRiskStatName() == null || getRiskStatName().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRiskStatName());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPRisk WHERE  RiskCode = ?", 1003, 1007);
		if (getRiskCode() == null || getRiskCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getRiskCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "LNPRiskDB";
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
				tError.moduleName = "LNPRiskDB";
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

	public LNPRiskSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskSet aLNPRiskSet = new LNPRiskSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRisk");
			LNPRiskSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPRiskSchema s1;
			for (; rs.next(); aLNPRiskSet.add(s1))
			{
				i++;
				s1 = new LNPRiskSchema();
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
			tError.moduleName = "LNPRiskDB";
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
		return aLNPRiskSet;
	}

	public LNPRiskSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskSet aLNPRiskSet = new LNPRiskSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPRiskSchema s1;
			for (; rs.next(); aLNPRiskSet.add(s1))
			{
				i++;
				s1 = new LNPRiskSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
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
		return aLNPRiskSet;
	}

	public LNPRiskSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskSet aLNPRiskSet = new LNPRiskSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRisk");
			LNPRiskSchema aSchema = getSchema();
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
				LNPRiskSchema s1 = new LNPRiskSchema();
				s1.setSchema(rs, i);
				aLNPRiskSet.add(s1);
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
			tError.moduleName = "LNPRiskDB";
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
		return aLNPRiskSet;
	}

	public LNPRiskSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskSet aLNPRiskSet = new LNPRiskSet();
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
				LNPRiskSchema s1 = new LNPRiskSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPRiskSet.add(s1);
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
			tError.moduleName = "LNPRiskDB";
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
		return aLNPRiskSet;
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
				SQLString sqlObj = new SQLString("LNPRisk");
				LNPRiskSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPRisk ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPRiskDB";
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
				tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
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

	public LNPRiskSet getData()
	{
		int tCount = 0;
		LNPRiskSet tLNPRiskSet = new LNPRiskSet();
		LNPRiskSchema tLNPRiskSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPRiskSchema = new LNPRiskSchema();
			tLNPRiskSchema.setSchema(mResultSet, 1);
			tLNPRiskSet.add(tLNPRiskSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPRiskSchema = new LNPRiskSchema();
					tLNPRiskSchema.setSchema(mResultSet, 1);
					tLNPRiskSet.add(tLNPRiskSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskDB";
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
		return tLNPRiskSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPRiskDB";
				tError.functionName = "closeData";
				tError.errorMessage = "数据集已经关闭了�?";
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
			tError.moduleName = "LNPRiskDB";
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
				tError.moduleName = "LNPRiskDB";
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
			tError.moduleName = "LNPRiskDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
