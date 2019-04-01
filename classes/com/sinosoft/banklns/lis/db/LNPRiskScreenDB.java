// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPRiskScreenDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPRiskScreenSchema;
import com.sinosoft.banklns.lis.vschema.LNPRiskScreenSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPRiskScreenDB extends LNPRiskScreenSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPRiskScreenDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPRiskScreen");
		mflag = true;
	}

	public LNPRiskScreenDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPRiskScreen");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPRiskScreenSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPRiskScreenSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			pstmt.setInt(2, getCtrlIndex());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
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
			pstmt = con.prepareStatement("UPDATE LNPRiskScreen SET  RiskCode = ? , CtrlIndex = ? , CtrlType = ? , CtrlCode = ? , CtrlName = ? , CtrlLevel = ? , CtrlProperty = ? , CtrlAlignX = ? , CtrlAlignY = ? , CtrlHorizontal = ? , CtrlVertical = ? , CtrlBackground = ? , LabelAlignX = ? , LabelAlignY = ? , LabelHorizontal = ? , LabelVertical = ? , LabelBackground = ? , DefaultValue = ? , DefaultSql = ? , CtrlProperty1 = ? , CtrlProperty2 = ? , Noti = ? WHERE  RiskCode = ? AND CtrlIndex = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			pstmt.setInt(2, getCtrlIndex());
			if (getCtrlType() == null || getCtrlType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCtrlType());
			if (getCtrlCode() == null || getCtrlCode().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getCtrlCode());
			if (getCtrlName() == null || getCtrlName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getCtrlName());
			if (getCtrlLevel() == null || getCtrlLevel().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getCtrlLevel());
			if (getCtrlProperty() == null || getCtrlProperty().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCtrlProperty());
			pstmt.setInt(8, getCtrlAlignX());
			pstmt.setInt(9, getCtrlAlignY());
			pstmt.setInt(10, getCtrlHorizontal());
			pstmt.setInt(11, getCtrlVertical());
			if (getCtrlBackground() == null || getCtrlBackground().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCtrlBackground());
			pstmt.setInt(13, getLabelAlignX());
			pstmt.setInt(14, getLabelAlignY());
			pstmt.setInt(15, getLabelHorizontal());
			pstmt.setInt(16, getLabelVertical());
			if (getLabelBackground() == null || getLabelBackground().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getLabelBackground());
			if (getDefaultValue() == null || getDefaultValue().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getDefaultValue());
			if (getDefaultSql() == null || getDefaultSql().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getDefaultSql());
			if (getCtrlProperty1() == null || getCtrlProperty1().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getCtrlProperty1());
			if (getCtrlProperty2() == null || getCtrlProperty2().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getCtrlProperty2());
			if (getNoti() == null || getNoti().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getNoti());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getRiskCode());
			pstmt.setInt(24, getCtrlIndex());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPRiskScreen VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			pstmt.setInt(2, getCtrlIndex());
			if (getCtrlType() == null || getCtrlType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getCtrlType());
			if (getCtrlCode() == null || getCtrlCode().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getCtrlCode());
			if (getCtrlName() == null || getCtrlName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getCtrlName());
			if (getCtrlLevel() == null || getCtrlLevel().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getCtrlLevel());
			if (getCtrlProperty() == null || getCtrlProperty().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCtrlProperty());
			pstmt.setInt(8, getCtrlAlignX());
			pstmt.setInt(9, getCtrlAlignY());
			pstmt.setInt(10, getCtrlHorizontal());
			pstmt.setInt(11, getCtrlVertical());
			if (getCtrlBackground() == null || getCtrlBackground().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCtrlBackground());
			pstmt.setInt(13, getLabelAlignX());
			pstmt.setInt(14, getLabelAlignY());
			pstmt.setInt(15, getLabelHorizontal());
			pstmt.setInt(16, getLabelVertical());
			if (getLabelBackground() == null || getLabelBackground().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getLabelBackground());
			if (getDefaultValue() == null || getDefaultValue().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getDefaultValue());
			if (getDefaultSql() == null || getDefaultSql().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getDefaultSql());
			if (getCtrlProperty1() == null || getCtrlProperty1().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getCtrlProperty1());
			if (getCtrlProperty2() == null || getCtrlProperty2().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getCtrlProperty2());
			if (getNoti() == null || getNoti().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getNoti());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPRiskScreen WHERE  RiskCode = ? AND CtrlIndex = ?", 1003, 1007);
		if (getRiskCode() == null || getRiskCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getRiskCode());
		pstmt.setInt(2, getCtrlIndex());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_203;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_203;
		CError tError = new CError();
		tError.moduleName = "LNPRiskScreenDB";
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
				tError.moduleName = "LNPRiskScreenDB";
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

	public LNPRiskScreenSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskScreen");
			LNPRiskScreenSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPRiskScreenSchema s1;
			for (; rs.next(); aLNPRiskScreenSet.add(s1))
			{
				i++;
				s1 = new LNPRiskScreenSchema();
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
			tError.moduleName = "LNPRiskScreenDB";
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
		return aLNPRiskScreenSet;
	}

	public LNPRiskScreenSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPRiskScreenSchema s1;
			for (; rs.next(); aLNPRiskScreenSet.add(s1))
			{
				i++;
				s1 = new LNPRiskScreenSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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
		return aLNPRiskScreenSet;
	}

	public LNPRiskScreenSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPRiskScreen");
			LNPRiskScreenSchema aSchema = getSchema();
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
				LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
				s1.setSchema(rs, i);
				aLNPRiskScreenSet.add(s1);
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
			tError.moduleName = "LNPRiskScreenDB";
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
		return aLNPRiskScreenSet;
	}

	public LNPRiskScreenSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPRiskScreenSet aLNPRiskScreenSet = new LNPRiskScreenSet();
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
				LNPRiskScreenSchema s1 = new LNPRiskScreenSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPRiskScreenDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPRiskScreenSet.add(s1);
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
			tError.moduleName = "LNPRiskScreenDB";
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
		return aLNPRiskScreenSet;
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
				SQLString sqlObj = new SQLString("LNPRiskScreen");
				LNPRiskScreenSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPRiskScreen ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPRiskScreenDB";
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
				tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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

	public LNPRiskScreenSet getData()
	{
		int tCount = 0;
		LNPRiskScreenSet tLNPRiskScreenSet = new LNPRiskScreenSet();
		LNPRiskScreenSchema tLNPRiskScreenSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPRiskScreenSchema = new LNPRiskScreenSchema();
			tLNPRiskScreenSchema.setSchema(mResultSet, 1);
			tLNPRiskScreenSet.add(tLNPRiskScreenSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPRiskScreenSchema = new LNPRiskScreenSchema();
					tLNPRiskScreenSchema.setSchema(mResultSet, 1);
					tLNPRiskScreenSet.add(tLNPRiskScreenSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPRiskScreenDB";
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
		return tLNPRiskScreenSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
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
				tError.moduleName = "LNPRiskScreenDB";
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
			tError.moduleName = "LNPRiskScreenDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
