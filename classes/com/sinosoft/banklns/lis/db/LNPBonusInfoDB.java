// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPBonusInfoDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPBonusInfoSchema;
import com.sinosoft.banklns.lis.vschema.LNPBonusInfoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPBonusInfoDB extends LNPBonusInfoSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPBonusInfoDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPBonusInfo");
		mflag = true;
	}

	public LNPBonusInfoDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPBonusInfo");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPBonusInfoSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPBonusInfoSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPBonusInfo WHERE  ContNo = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
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
			pstmt = con.prepareStatement("UPDATE LNPBonusInfo SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , PrtNo = ? , BonusType = ? , BonusWay = ? , AutoRepaid = ? , cutPayAll = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , p2 = ? , p4 = ? , p3 = ? , p1 = ? WHERE  ContNo = ?");
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
			if (getBonusType() == null || getBonusType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBonusType());
			if (getBonusWay() == null || getBonusWay().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBonusWay());
			if (getAutoRepaid() == null || getAutoRepaid().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAutoRepaid());
			if (getCutPayAll() == null || getCutPayAll().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCutPayAll());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getModifyTime());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getP2());
			if (getP4() == null || getP4().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getP4());
			if (getP3() == null || getP3().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP3());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getP1());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getContNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPBonusInfo VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getBonusType() == null || getBonusType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBonusType());
			if (getBonusWay() == null || getBonusWay().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBonusWay());
			if (getAutoRepaid() == null || getAutoRepaid().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getAutoRepaid());
			if (getCutPayAll() == null || getCutPayAll().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCutPayAll());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(12, 91);
			else
				pstmt.setDate(12, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getModifyTime());
			if (getP2() == null || getP2().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getP2());
			if (getP4() == null || getP4().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getP4());
			if (getP3() == null || getP3().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getP3());
			if (getP1() == null || getP1().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getP1());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPBonusInfo WHERE  ContNo = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "LNPBonusInfoDB";
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
				tError.moduleName = "LNPBonusInfoDB";
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

	public LNPBonusInfoSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPBonusInfo");
			LNPBonusInfoSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPBonusInfoSchema s1;
			for (; rs.next(); aLNPBonusInfoSet.add(s1))
			{
				i++;
				s1 = new LNPBonusInfoSchema();
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
			tError.moduleName = "LNPBonusInfoDB";
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
		return aLNPBonusInfoSet;
	}

	public LNPBonusInfoSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPBonusInfoSchema s1;
			for (; rs.next(); aLNPBonusInfoSet.add(s1))
			{
				i++;
				s1 = new LNPBonusInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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
		return aLNPBonusInfoSet;
	}

	public LNPBonusInfoSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPBonusInfo");
			LNPBonusInfoSchema aSchema = getSchema();
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
				LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
				s1.setSchema(rs, i);
				aLNPBonusInfoSet.add(s1);
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
			tError.moduleName = "LNPBonusInfoDB";
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
		return aLNPBonusInfoSet;
	}

	public LNPBonusInfoSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPBonusInfoSet aLNPBonusInfoSet = new LNPBonusInfoSet();
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
				LNPBonusInfoSchema s1 = new LNPBonusInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPBonusInfoDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPBonusInfoSet.add(s1);
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
			tError.moduleName = "LNPBonusInfoDB";
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
		return aLNPBonusInfoSet;
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
				SQLString sqlObj = new SQLString("LNPBonusInfo");
				LNPBonusInfoSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPBonusInfo ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPBonusInfoDB";
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
				tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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

	public LNPBonusInfoSet getData()
	{
		int tCount = 0;
		LNPBonusInfoSet tLNPBonusInfoSet = new LNPBonusInfoSet();
		LNPBonusInfoSchema tLNPBonusInfoSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPBonusInfoSchema = new LNPBonusInfoSchema();
			tLNPBonusInfoSchema.setSchema(mResultSet, 1);
			tLNPBonusInfoSet.add(tLNPBonusInfoSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPBonusInfoSchema = new LNPBonusInfoSchema();
					tLNPBonusInfoSchema.setSchema(mResultSet, 1);
					tLNPBonusInfoSet.add(tLNPBonusInfoSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPBonusInfoDB";
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
		return tLNPBonusInfoSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
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
				tError.moduleName = "LNPBonusInfoDB";
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
			tError.moduleName = "LNPBonusInfoDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
