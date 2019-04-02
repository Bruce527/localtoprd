// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsureHistoryDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPInsureHistorySchema;
import com.sinosoft.banklns.lis.vschema.LNPInsureHistorySet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPInsureHistoryDB extends LNPInsureHistorySchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPInsureHistoryDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPInsureHistory");
		mflag = true;
	}

	public LNPInsureHistoryDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPInsureHistory");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPInsureHistorySchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPInsureHistorySchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			if (getPolOrder() == null || getPolOrder().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getPolOrder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
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
			pstmt = con.prepareStatement("UPDATE LNPInsureHistory SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , PolOrder = ? , ComName = ? , SumInsuredDeath = ? , SumInsuredDisease = ? , PolicyState = ? , State = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ? AND PolOrder = ?");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getProposalContNo());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPrtNo());
			if (getPolOrder() == null || getPolOrder().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPolOrder());
			if (getComName() == null || getComName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getComName());
			pstmt.setDouble(7, getSumInsuredDeath());
			pstmt.setDouble(8, getSumInsuredDisease());
			if (getPolicyState() == null || getPolicyState().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolicyState());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getModifyTime());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP2());
			pstmt.setDouble(17, getP4());
			pstmt.setDouble(18, getP3());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getP1());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getContNo());
			if (getPolOrder() == null || getPolOrder().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getPolOrder());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPInsureHistory VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getGrpContNo() == null || getGrpContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGrpContNo());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getContNo());
			if (getProposalContNo() == null || getProposalContNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getProposalContNo());
			if (getPrtNo() == null || getPrtNo().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPrtNo());
			if (getPolOrder() == null || getPolOrder().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPolOrder());
			if (getComName() == null || getComName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getComName());
			pstmt.setDouble(7, getSumInsuredDeath());
			pstmt.setDouble(8, getSumInsuredDisease());
			if (getPolicyState() == null || getPolicyState().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getPolicyState());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getState());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(14, 91);
			else
				pstmt.setDate(14, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getModifyTime());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP2());
			pstmt.setDouble(17, getP4());
			pstmt.setDouble(18, getP3());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getP1());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPInsureHistory WHERE  ContNo = ? AND PolOrder = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		if (getPolOrder() == null || getPolOrder().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getPolOrder());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_234;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_234;
		CError tError = new CError();
		tError.moduleName = "LNPInsureHistoryDB";
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
				tError.moduleName = "LNPInsureHistoryDB";
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

	public LNPInsureHistorySet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPInsureHistory");
			LNPInsureHistorySchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPInsureHistorySchema s1;
			for (; rs.next(); aLNPInsureHistorySet.add(s1))
			{
				i++;
				s1 = new LNPInsureHistorySchema();
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
			tError.moduleName = "LNPInsureHistoryDB";
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
		return aLNPInsureHistorySet;
	}

	public LNPInsureHistorySet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPInsureHistorySchema s1;
			for (; rs.next(); aLNPInsureHistorySet.add(s1))
			{
				i++;
				s1 = new LNPInsureHistorySchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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
		return aLNPInsureHistorySet;
	}

	public LNPInsureHistorySet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPInsureHistory");
			LNPInsureHistorySchema aSchema = getSchema();
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
				LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
				s1.setSchema(rs, i);
				aLNPInsureHistorySet.add(s1);
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
			tError.moduleName = "LNPInsureHistoryDB";
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
		return aLNPInsureHistorySet;
	}

	public LNPInsureHistorySet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPInsureHistorySet aLNPInsureHistorySet = new LNPInsureHistorySet();
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
				LNPInsureHistorySchema s1 = new LNPInsureHistorySchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPInsureHistoryDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPInsureHistorySet.add(s1);
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
			tError.moduleName = "LNPInsureHistoryDB";
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
		return aLNPInsureHistorySet;
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
				SQLString sqlObj = new SQLString("LNPInsureHistory");
				LNPInsureHistorySchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPInsureHistory ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPInsureHistoryDB";
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
				tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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

	public LNPInsureHistorySet getData()
	{
		int tCount = 0;
		LNPInsureHistorySet tLNPInsureHistorySet = new LNPInsureHistorySet();
		LNPInsureHistorySchema tLNPInsureHistorySchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPInsureHistorySchema = new LNPInsureHistorySchema();
			tLNPInsureHistorySchema.setSchema(mResultSet, 1);
			tLNPInsureHistorySet.add(tLNPInsureHistorySchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPInsureHistorySchema = new LNPInsureHistorySchema();
					tLNPInsureHistorySchema.setSchema(mResultSet, 1);
					tLNPInsureHistorySet.add(tLNPInsureHistorySchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPInsureHistoryDB";
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
		return tLNPInsureHistorySet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
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
				tError.moduleName = "LNPInsureHistoryDB";
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
			tError.moduleName = "LNPInsureHistoryDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
