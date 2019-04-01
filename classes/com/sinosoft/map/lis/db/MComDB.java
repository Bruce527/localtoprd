// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MComDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MComSchema;
import com.sinosoft.map.lis.vschema.MComSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MComDB extends MComSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MComDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MCom");
		mflag = true;
	}

	public MComDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MCom");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MComSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MComDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MComSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MComDB";
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
			pstmt = con.prepareStatement("DELETE FROM MCom WHERE  ComCode = ?");
			if (getComCode() == null || getComCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getComCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MComDB";
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
			pstmt = con.prepareStatement("UPDATE MCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE  ComCode = ?");
			if (getComCode() == null || getComCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getComCode());
			if (getOutComCode() == null || getOutComCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getOutComCode());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getName());
			if (getShortName() == null || getShortName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getShortName());
			if (getAddress() == null || getAddress().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getZipCode());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getPhone());
			if (getFax() == null || getFax().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getFax());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getEMail());
			if (getWebAddress() == null || getWebAddress().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getWebAddress());
			if (getSatrapName() == null || getSatrapName().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getSatrapName());
			if (getInsuMonitorCode() == null || getInsuMonitorCode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getInsuMonitorCode());
			if (getInsureID() == null || getInsureID().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getInsureID());
			if (getSignID() == null || getSignID().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getSignID());
			if (getCountry() == null || getCountry().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCountry());
			if (getProvince() == null || getProvince().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getProvince());
			if (getCity() == null || getCity().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCity());
			if (getComNature() == null || getComNature().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getComNature());
			if (getValidCode() == null || getValidCode().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getValidCode());
			if (getSign() == null || getSign().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSign());
			if (getComCode() == null || getComCode().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getComCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MComDB";
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
			pstmt = con.prepareStatement("INSERT INTO MCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getComCode() == null || getComCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getComCode());
			if (getOutComCode() == null || getOutComCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getOutComCode());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getName());
			if (getShortName() == null || getShortName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getShortName());
			if (getAddress() == null || getAddress().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getZipCode());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getPhone());
			if (getFax() == null || getFax().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getFax());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getEMail());
			if (getWebAddress() == null || getWebAddress().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getWebAddress());
			if (getSatrapName() == null || getSatrapName().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getSatrapName());
			if (getInsuMonitorCode() == null || getInsuMonitorCode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getInsuMonitorCode());
			if (getInsureID() == null || getInsureID().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getInsureID());
			if (getSignID() == null || getSignID().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getSignID());
			if (getCountry() == null || getCountry().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCountry());
			if (getProvince() == null || getProvince().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getProvince());
			if (getCity() == null || getCity().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCity());
			if (getComNature() == null || getComNature().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getComNature());
			if (getValidCode() == null || getValidCode().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getValidCode());
			if (getSign() == null || getSign().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSign());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MComDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MCom WHERE  ComCode = ?", 1003, 1007);
		if (getComCode() == null || getComCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getComCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "MComDB";
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
				tError.moduleName = "MComDB";
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

	public MComSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MComSet aMComSet = new MComSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MCom");
			MComSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MComSchema s1;
			for (; rs.next(); aMComSet.add(s1))
			{
				i++;
				s1 = new MComSchema();
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
			tError.moduleName = "MComDB";
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
		return aMComSet;
	}

	public MComSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MComSet aMComSet = new MComSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MComSchema s1;
			for (; rs.next(); aMComSet.add(s1))
			{
				i++;
				s1 = new MComSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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
		return aMComSet;
	}

	public MComSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MComSet aMComSet = new MComSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MCom");
			MComSchema aSchema = getSchema();
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
				MComSchema s1 = new MComSchema();
				s1.setSchema(rs, i);
				aMComSet.add(s1);
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
			tError.moduleName = "MComDB";
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
		return aMComSet;
	}

	public MComSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MComSet aMComSet = new MComSet();
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
				MComSchema s1 = new MComSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MComDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMComSet.add(s1);
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
			tError.moduleName = "MComDB";
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
		return aMComSet;
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
				SQLString sqlObj = new SQLString("MCom");
				MComSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MCom ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MComDB";
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
				tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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

	public MComSet getData()
	{
		int tCount = 0;
		MComSet tMComSet = new MComSet();
		MComSchema tMComSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MComDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMComSchema = new MComSchema();
			tMComSchema.setSchema(mResultSet, 1);
			tMComSet.add(tMComSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMComSchema = new MComSchema();
					tMComSchema.setSchema(mResultSet, 1);
					tMComSet.add(tMComSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MComDB";
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
		return tMComSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
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
				tError.moduleName = "MComDB";
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
			tError.moduleName = "MComDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
