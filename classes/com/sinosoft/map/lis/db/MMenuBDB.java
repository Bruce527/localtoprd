// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MMenuBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MMenuBSchema;
import com.sinosoft.map.lis.vschema.MMenuBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MMenuBDB extends MMenuBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MMenuBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MMenuB");
		mflag = true;
	}

	public MMenuBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MMenuB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MMenuBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MMenuBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MMenuB WHERE  EdorNo = ?");
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
			tError.moduleName = "MMenuBDB";
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
			pstmt = con.prepareStatement("UPDATE MMenuB SET  NodeCode = ? , ParentID = ? , NodeLevel = ? , NodeName = ? , ChildFlag = ? , NodeKey = ? , RunScript = ? , NodeDesc = ? , NodeSign = ? , NodeOrder = ? , Int1 = ? , Int2 = ? , Varc1 = ? , Varc2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			if (getNodeCode() == null || getNodeCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNodeCode());
			if (getParentID() == null || getParentID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getParentID());
			if (getNodeLevel() == null || getNodeLevel().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getNodeLevel());
			if (getNodeName() == null || getNodeName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getNodeName());
			if (getChildFlag() == null || getChildFlag().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getChildFlag());
			if (getNodeKey() == null || getNodeKey().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getNodeKey());
			if (getRunScript() == null || getRunScript().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRunScript());
			if (getNodeDesc() == null || getNodeDesc().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getNodeDesc());
			if (getNodeSign() == null || getNodeSign().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getNodeSign());
			pstmt.setInt(10, getNodeOrder());
			pstmt.setInt(11, getInt1());
			pstmt.setInt(12, getInt2());
			if (getVarc1() == null || getVarc1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVarc1());
			if (getVarc2() == null || getVarc2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getVarc2());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getModifyTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getMakeTime2());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MMenuB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getNodeCode() == null || getNodeCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNodeCode());
			if (getParentID() == null || getParentID().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getParentID());
			if (getNodeLevel() == null || getNodeLevel().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getNodeLevel());
			if (getNodeName() == null || getNodeName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getNodeName());
			if (getChildFlag() == null || getChildFlag().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getChildFlag());
			if (getNodeKey() == null || getNodeKey().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getNodeKey());
			if (getRunScript() == null || getRunScript().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getRunScript());
			if (getNodeDesc() == null || getNodeDesc().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getNodeDesc());
			if (getNodeSign() == null || getNodeSign().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getNodeSign());
			pstmt.setInt(10, getNodeOrder());
			pstmt.setInt(11, getInt1());
			pstmt.setInt(12, getInt2());
			if (getVarc1() == null || getVarc1().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getVarc1());
			if (getVarc2() == null || getVarc2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getVarc2());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(16, 91);
			else
				pstmt.setDate(16, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getModifyTime());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getOperator2());
			if (getMakeDate2() == null || getMakeDate2().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getMakeDate2()));
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getMakeTime2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MMenuB WHERE  EdorNo = ?", 1003, 1007);
		if (getEdorNo() == null || getEdorNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getEdorNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_194;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_194;
		CError tError = new CError();
		tError.moduleName = "MMenuBDB";
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
				tError.moduleName = "MMenuBDB";
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

	public MMenuBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMenuBSet aMMenuBSet = new MMenuBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MMenuB");
			MMenuBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MMenuBSchema s1;
			for (; rs.next(); aMMenuBSet.add(s1))
			{
				i++;
				s1 = new MMenuBSchema();
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
			tError.moduleName = "MMenuBDB";
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
		return aMMenuBSet;
	}

	public MMenuBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMenuBSet aMMenuBSet = new MMenuBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MMenuBSchema s1;
			for (; rs.next(); aMMenuBSet.add(s1))
			{
				i++;
				s1 = new MMenuBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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
		return aMMenuBSet;
	}

	public MMenuBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMenuBSet aMMenuBSet = new MMenuBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MMenuB");
			MMenuBSchema aSchema = getSchema();
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
				MMenuBSchema s1 = new MMenuBSchema();
				s1.setSchema(rs, i);
				aMMenuBSet.add(s1);
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
			tError.moduleName = "MMenuBDB";
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
		return aMMenuBSet;
	}

	public MMenuBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MMenuBSet aMMenuBSet = new MMenuBSet();
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
				MMenuBSchema s1 = new MMenuBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MMenuBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMMenuBSet.add(s1);
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
			tError.moduleName = "MMenuBDB";
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
		return aMMenuBSet;
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
				SQLString sqlObj = new SQLString("MMenuB");
				MMenuBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MMenuB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MMenuBDB";
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
				tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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

	public MMenuBSet getData()
	{
		int tCount = 0;
		MMenuBSet tMMenuBSet = new MMenuBSet();
		MMenuBSchema tMMenuBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMMenuBSchema = new MMenuBSchema();
			tMMenuBSchema.setSchema(mResultSet, 1);
			tMMenuBSet.add(tMMenuBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMMenuBSchema = new MMenuBSchema();
					tMMenuBSchema.setSchema(mResultSet, 1);
					tMMenuBSet.add(tMMenuBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MMenuBDB";
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
		return tMMenuBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
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
				tError.moduleName = "MMenuBDB";
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
			tError.moduleName = "MMenuBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
