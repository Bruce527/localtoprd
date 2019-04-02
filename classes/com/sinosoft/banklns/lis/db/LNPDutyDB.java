// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPDutySchema;
import com.sinosoft.banklns.lis.vschema.LNPDutySet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPDutyDB extends LNPDutySchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPDutyDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPDuty");
		mflag = true;
	}

	public LNPDutyDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPDuty");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPDutySchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPDutySchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDuty WHERE  DutyCode = ?");
			if (getDutyCode() == null || getDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getDutyCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
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
			pstmt = con.prepareStatement("UPDATE LNPDuty SET  DutyCode = ? , DutyName = ? , PayEndYear = ? , PayEndYearFlag = ? , PayEndDateCalRef = ? , PayEndDateCalMode = ? , GetYear = ? , GetYearFlag = ? , InsuYear = ? , InsuYearFlag = ? , AcciYear = ? , AcciYearFlag = ? , CalMode = ? , PayEndYearRela = ? , GetYearRela = ? , InsuYearRela = ? , BasicCalCode = ? , RiskCalCode = ? , AmntFlag = ? , VPU = ? , AddFeeFlag = ? , EndDateCalMode = ? WHERE  DutyCode = ?");
			if (getDutyCode() == null || getDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getDutyCode());
			if (getDutyName() == null || getDutyName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getDutyName());
			pstmt.setInt(3, getPayEndYear());
			if (getPayEndYearFlag() == null || getPayEndYearFlag().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPayEndYearFlag());
			if (getPayEndDateCalRef() == null || getPayEndDateCalRef().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPayEndDateCalRef());
			if (getPayEndDateCalMode() == null || getPayEndDateCalMode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPayEndDateCalMode());
			pstmt.setInt(7, getGetYear());
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getGetYearFlag());
			pstmt.setInt(9, getInsuYear());
			if (getInsuYearFlag() == null || getInsuYearFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getInsuYearFlag());
			pstmt.setInt(11, getAcciYear());
			if (getAcciYearFlag() == null || getAcciYearFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAcciYearFlag());
			if (getCalMode() == null || getCalMode().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCalMode());
			if (getPayEndYearRela() == null || getPayEndYearRela().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getPayEndYearRela());
			if (getGetYearRela() == null || getGetYearRela().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getGetYearRela());
			if (getInsuYearRela() == null || getInsuYearRela().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getInsuYearRela());
			if (getBasicCalCode() == null || getBasicCalCode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getBasicCalCode());
			if (getRiskCalCode() == null || getRiskCalCode().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRiskCalCode());
			if (getAmntFlag() == null || getAmntFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAmntFlag());
			pstmt.setDouble(20, getVPU());
			if (getAddFeeFlag() == null || getAddFeeFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAddFeeFlag());
			if (getEndDateCalMode() == null || getEndDateCalMode().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getEndDateCalMode());
			if (getDutyCode() == null || getDutyCode().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getDutyCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDuty VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getDutyCode() == null || getDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getDutyCode());
			if (getDutyName() == null || getDutyName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getDutyName());
			pstmt.setInt(3, getPayEndYear());
			if (getPayEndYearFlag() == null || getPayEndYearFlag().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPayEndYearFlag());
			if (getPayEndDateCalRef() == null || getPayEndDateCalRef().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPayEndDateCalRef());
			if (getPayEndDateCalMode() == null || getPayEndDateCalMode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPayEndDateCalMode());
			pstmt.setInt(7, getGetYear());
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getGetYearFlag());
			pstmt.setInt(9, getInsuYear());
			if (getInsuYearFlag() == null || getInsuYearFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getInsuYearFlag());
			pstmt.setInt(11, getAcciYear());
			if (getAcciYearFlag() == null || getAcciYearFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAcciYearFlag());
			if (getCalMode() == null || getCalMode().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCalMode());
			if (getPayEndYearRela() == null || getPayEndYearRela().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getPayEndYearRela());
			if (getGetYearRela() == null || getGetYearRela().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getGetYearRela());
			if (getInsuYearRela() == null || getInsuYearRela().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getInsuYearRela());
			if (getBasicCalCode() == null || getBasicCalCode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getBasicCalCode());
			if (getRiskCalCode() == null || getRiskCalCode().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getRiskCalCode());
			if (getAmntFlag() == null || getAmntFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAmntFlag());
			pstmt.setDouble(20, getVPU());
			if (getAddFeeFlag() == null || getAddFeeFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAddFeeFlag());
			if (getEndDateCalMode() == null || getEndDateCalMode().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getEndDateCalMode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPDuty WHERE  DutyCode = ?", 1003, 1007);
		if (getDutyCode() == null || getDutyCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getDutyCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_194;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_194;
		CError tError = new CError();
		tError.moduleName = "LNPDutyDB";
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
				tError.moduleName = "LNPDutyDB";
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

	public LNPDutySet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutySet aLNPDutySet = new LNPDutySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPDuty");
			LNPDutySchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPDutySchema s1;
			for (; rs.next(); aLNPDutySet.add(s1))
			{
				i++;
				s1 = new LNPDutySchema();
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
			tError.moduleName = "LNPDutyDB";
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
		return aLNPDutySet;
	}

	public LNPDutySet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutySet aLNPDutySet = new LNPDutySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPDutySchema s1;
			for (; rs.next(); aLNPDutySet.add(s1))
			{
				i++;
				s1 = new LNPDutySchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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
		return aLNPDutySet;
	}

	public LNPDutySet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutySet aLNPDutySet = new LNPDutySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPDuty");
			LNPDutySchema aSchema = getSchema();
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
				LNPDutySchema s1 = new LNPDutySchema();
				s1.setSchema(rs, i);
				aLNPDutySet.add(s1);
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
			tError.moduleName = "LNPDutyDB";
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
		return aLNPDutySet;
	}

	public LNPDutySet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutySet aLNPDutySet = new LNPDutySet();
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
				LNPDutySchema s1 = new LNPDutySchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPDutyDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPDutySet.add(s1);
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
			tError.moduleName = "LNPDutyDB";
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
		return aLNPDutySet;
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
				SQLString sqlObj = new SQLString("LNPDuty");
				LNPDutySchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPDuty ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPDutyDB";
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
				tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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

	public LNPDutySet getData()
	{
		int tCount = 0;
		LNPDutySet tLNPDutySet = new LNPDutySet();
		LNPDutySchema tLNPDutySchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPDutySchema = new LNPDutySchema();
			tLNPDutySchema.setSchema(mResultSet, 1);
			tLNPDutySet.add(tLNPDutySchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPDutySchema = new LNPDutySchema();
					tLNPDutySchema.setSchema(mResultSet, 1);
					tLNPDutySet.add(tLNPDutySchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyDB";
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
		return tLNPDutySet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
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
				tError.moduleName = "LNPDutyDB";
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
			tError.moduleName = "LNPDutyDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
