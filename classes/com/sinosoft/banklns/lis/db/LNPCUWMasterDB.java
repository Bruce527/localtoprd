// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCUWMasterDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPCUWMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPCUWMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPCUWMasterDB extends LNPCUWMasterSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPCUWMasterDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPCUWMaster");
		mflag = true;
	}

	public LNPCUWMasterDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPCUWMaster");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPCUWMasterSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPCUWMasterSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCUWMaster WHERE  ContNo = ?");
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
			tError.moduleName = "LNPCUWMasterDB";
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
			pstmt = con.prepareStatement("UPDATE LNPCUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UWDate = ? , UWTime = ? , UWerName = ? , CheckStatus = ? , AppIsCompleted = ? , AppIsSubmitted = ? , AppDecision = ? , AutoUWFlag = ? , UWMessages = ? , UWGrade = ? , AppGrade = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ?");
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
			pstmt.setInt(4, getUWNo());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getUWTime());
			if (getUWerName() == null || getUWerName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getUWerName());
			if (getCheckStatus() == null || getCheckStatus().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCheckStatus());
			if (getAppIsCompleted() == null || getAppIsCompleted().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppIsCompleted());
			if (getAppIsSubmitted() == null || getAppIsSubmitted().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAppIsSubmitted());
			if (getAppDecision() == null || getAppDecision().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAppDecision());
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAutoUWFlag());
			if (getUWMessages() == null || getUWMessages().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getUWMessages());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAppGrade());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getState());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getUpReportContent());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getAddPremReason());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getSpecReason());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getModifyTime());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getContNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			pstmt.setInt(4, getUWNo());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getManageCom());
			if (getUWDate() == null || getUWDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getUWDate()));
			if (getUWTime() == null || getUWTime().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getUWTime());
			if (getUWerName() == null || getUWerName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getUWerName());
			if (getCheckStatus() == null || getCheckStatus().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCheckStatus());
			if (getAppIsCompleted() == null || getAppIsCompleted().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getAppIsCompleted());
			if (getAppIsSubmitted() == null || getAppIsSubmitted().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAppIsSubmitted());
			if (getAppDecision() == null || getAppDecision().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAppDecision());
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAutoUWFlag());
			if (getUWMessages() == null || getUWMessages().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getUWMessages());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getAppGrade());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getState());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getUpReportContent());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getAddPremReason());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getSpecReason());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(26, 91);
			else
				pstmt.setDate(26, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(28, 91);
			else
				pstmt.setDate(28, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPCUWMaster WHERE  ContNo = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "LNPCUWMasterDB";
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
				tError.moduleName = "LNPCUWMasterDB";
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

	public LNPCUWMasterSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCUWMaster");
			LNPCUWMasterSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPCUWMasterSchema s1;
			for (; rs.next(); aLNPCUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPCUWMasterSchema();
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
			tError.moduleName = "LNPCUWMasterDB";
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
		return aLNPCUWMasterSet;
	}

	public LNPCUWMasterSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPCUWMasterSchema s1;
			for (; rs.next(); aLNPCUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPCUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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
		return aLNPCUWMasterSet;
	}

	public LNPCUWMasterSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPCUWMaster");
			LNPCUWMasterSchema aSchema = getSchema();
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
				LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
				s1.setSchema(rs, i);
				aLNPCUWMasterSet.add(s1);
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
			tError.moduleName = "LNPCUWMasterDB";
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
		return aLNPCUWMasterSet;
	}

	public LNPCUWMasterSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPCUWMasterSet aLNPCUWMasterSet = new LNPCUWMasterSet();
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
				LNPCUWMasterSchema s1 = new LNPCUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPCUWMasterDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPCUWMasterSet.add(s1);
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
			tError.moduleName = "LNPCUWMasterDB";
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
		return aLNPCUWMasterSet;
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
				SQLString sqlObj = new SQLString("LNPCUWMaster");
				LNPCUWMasterSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPCUWMaster ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterDB";
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
				tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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

	public LNPCUWMasterSet getData()
	{
		int tCount = 0;
		LNPCUWMasterSet tLNPCUWMasterSet = new LNPCUWMasterSet();
		LNPCUWMasterSchema tLNPCUWMasterSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPCUWMasterSchema = new LNPCUWMasterSchema();
			tLNPCUWMasterSchema.setSchema(mResultSet, 1);
			tLNPCUWMasterSet.add(tLNPCUWMasterSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPCUWMasterSchema = new LNPCUWMasterSchema();
					tLNPCUWMasterSchema.setSchema(mResultSet, 1);
					tLNPCUWMasterSet.add(tLNPCUWMasterSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPCUWMasterDB";
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
		return tLNPCUWMasterSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
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
				tError.moduleName = "LNPCUWMasterDB";
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
			tError.moduleName = "LNPCUWMasterDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
