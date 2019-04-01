// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCheckFieldDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCheckFieldDB extends LNPCheckFieldSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPCheckFieldDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPCheckField");
		mflag = true;
	}

	public LNPCheckFieldDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPCheckField");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPCheckFieldSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPCheckFieldSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getFieldName() == null || getFieldName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getFieldName());
			if (getSerialNo() == null || getSerialNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getSerialNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
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
			pstmt = con.prepareStatement("UPDATE LNPCheckField SET  RiskCode = ? , RiskVer = ? , FieldName = ? , SerialNo = ? , CalCode = ? , PageLocation = ? , Location = ? , Msg = ? , MsgFlag = ? , UpdFlag = ? , ValiFlag = ? , ReturnValiFlag = ? WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getFieldName() == null || getFieldName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getFieldName());
			if (getSerialNo() == null || getSerialNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getSerialNo());
			if (getCalCode() == null || getCalCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getCalCode());
			if (getPageLocation() == null || getPageLocation().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPageLocation());
			if (getLocation() == null || getLocation().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getLocation());
			if (getMsg() == null || getMsg().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getMsg());
			if (getMsgFlag() == null || getMsgFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMsgFlag());
			if (getUpdFlag() == null || getUpdFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getUpdFlag());
			if (getValiFlag() == null || getValiFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getValiFlag());
			if (getReturnValiFlag() == null || getReturnValiFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getReturnValiFlag());
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRiskVer());
			if (getFieldName() == null || getFieldName().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getFieldName());
			if (getSerialNo() == null || getSerialNo().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getSerialNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCheckField VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getRiskCode() == null || getRiskCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getRiskCode());
			if (getRiskVer() == null || getRiskVer().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRiskVer());
			if (getFieldName() == null || getFieldName().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getFieldName());
			if (getSerialNo() == null || getSerialNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getSerialNo());
			if (getCalCode() == null || getCalCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getCalCode());
			if (getPageLocation() == null || getPageLocation().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPageLocation());
			if (getLocation() == null || getLocation().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getLocation());
			if (getMsg() == null || getMsg().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getMsg());
			if (getMsgFlag() == null || getMsgFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getMsgFlag());
			if (getUpdFlag() == null || getUpdFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getUpdFlag());
			if (getValiFlag() == null || getValiFlag().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getValiFlag());
			if (getReturnValiFlag() == null || getReturnValiFlag().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getReturnValiFlag());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?", 1003, 1007);
		if (getRiskCode() == null || getRiskCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getRiskCode());
		if (getRiskVer() == null || getRiskVer().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getRiskVer());
		if (getFieldName() == null || getFieldName().equals("null"))
			pstmt.setNull(3, 12);
		else
			pstmt.setString(3, getFieldName());
		if (getSerialNo() == null || getSerialNo().equals("null"))
			pstmt.setNull(4, 12);
		else
			pstmt.setString(4, getSerialNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_318;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_318;
		CError tError = new CError();
		tError.moduleName = "LNPCheckFieldDB";
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
				tError.moduleName = "LNPCheckFieldDB";
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

	public LNPCheckFieldSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCheckField");
			LNPCheckFieldSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPCheckFieldSchema s1;
			for (; rs.next(); aLNPCheckFieldSet.add(s1))
			{
				i++;
				s1 = new LNPCheckFieldSchema();
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
			tError.moduleName = "LNPCheckFieldDB";
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
		return aLNPCheckFieldSet;
	}

	public LNPCheckFieldSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPCheckFieldSchema s1;
			for (; rs.next(); aLNPCheckFieldSet.add(s1))
			{
				i++;
				s1 = new LNPCheckFieldSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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
		return aLNPCheckFieldSet;
	}

	public LNPCheckFieldSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCheckField");
			LNPCheckFieldSchema aSchema = getSchema();
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
				LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
				s1.setSchema(rs, i);
				aLNPCheckFieldSet.add(s1);
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
			tError.moduleName = "LNPCheckFieldDB";
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
		return aLNPCheckFieldSet;
	}

	public LNPCheckFieldSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCheckFieldSet aLNPCheckFieldSet = new LNPCheckFieldSet();
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
				LNPCheckFieldSchema s1 = new LNPCheckFieldSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCheckFieldDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPCheckFieldSet.add(s1);
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
			tError.moduleName = "LNPCheckFieldDB";
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
		return aLNPCheckFieldSet;
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
				SQLString sqlObj = new SQLString("LNPCheckField");
				LNPCheckFieldSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPCheckField ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPCheckFieldDB";
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
				tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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

	public LNPCheckFieldSet getData()
	{
		int tCount = 0;
		LNPCheckFieldSet tLNPCheckFieldSet = new LNPCheckFieldSet();
		LNPCheckFieldSchema tLNPCheckFieldSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPCheckFieldSchema = new LNPCheckFieldSchema();
			tLNPCheckFieldSchema.setSchema(mResultSet, 1);
			tLNPCheckFieldSet.add(tLNPCheckFieldSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPCheckFieldSchema = new LNPCheckFieldSchema();
					tLNPCheckFieldSchema.setSchema(mResultSet, 1);
					tLNPCheckFieldSet.add(tLNPCheckFieldSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCheckFieldDB";
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
		return tLNPCheckFieldSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
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
				tError.moduleName = "LNPCheckFieldDB";
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
			tError.moduleName = "LNPCheckFieldDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
