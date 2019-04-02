// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPIndUWMasterDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPIndUWMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPIndUWMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPIndUWMasterDB extends LNPIndUWMasterSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPIndUWMasterDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPIndUWMaster");
		mflag = true;
	}

	public LNPIndUWMasterDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPIndUWMaster");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPIndUWMasterSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPIndUWMasterSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPIndUWMaster WHERE  ContNo = ? AND InsuredId = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getInsuredId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
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
			pstmt = con.prepareStatement("UPDATE LNPIndUWMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , InsuredId = ? , InsuredNo = ? , InsuredName = ? , FlagCaseDcl = ? , HighFaceAmount = ? , UWMessages = ? , AppntId = ? , AppntNo = ? , AppntName = ? , PassFlag = ? , UWIdea = ? , UWGrade = ? , AppGrade = ? , PostponeDay = ? , PostponeDate = ? , AutoUWFlag = ? , State = ? , UpReportContent = ? , HealthFlag = ? , QuesFlag = ? , SpecFlag = ? , AddPremFlag = ? , AddPremReason = ? , ReportFlag = ? , SpecReason = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ?");
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
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getInsuredId());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInsuredNo());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getInsuredName());
			if (getFlagCaseDcl() == null || getFlagCaseDcl().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getFlagCaseDcl());
			if (getHighFaceAmount() == null || getHighFaceAmount().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getHighFaceAmount());
			if (getUWMessages() == null || getUWMessages().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getUWMessages());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAppntId());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAppntName());
			if (getPassFlag() == null || getPassFlag().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPassFlag());
			if (getUWIdea() == null || getUWIdea().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getUWIdea());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAppGrade());
			if (getPostponeDay() == null || getPostponeDay().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getPostponeDay());
			if (getPostponeDate() == null || getPostponeDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getPostponeDate()));
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAutoUWFlag());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getState());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getUpReportContent());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAddPremReason());
			if (getReportFlag() == null || getReportFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getReportFlag());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getSpecReason());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getModifyTime());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getContNo());
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getInsuredId());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPIndUWMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
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
			if (getInsuredId() == null || getInsuredId().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getInsuredId());
			if (getInsuredNo() == null || getInsuredNo().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getInsuredNo());
			if (getInsuredName() == null || getInsuredName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getInsuredName());
			if (getFlagCaseDcl() == null || getFlagCaseDcl().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getFlagCaseDcl());
			if (getHighFaceAmount() == null || getHighFaceAmount().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getHighFaceAmount());
			if (getUWMessages() == null || getUWMessages().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getUWMessages());
			if (getAppntId() == null || getAppntId().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getAppntId());
			if (getAppntNo() == null || getAppntNo().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAppntNo());
			if (getAppntName() == null || getAppntName().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getAppntName());
			if (getPassFlag() == null || getPassFlag().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getPassFlag());
			if (getUWIdea() == null || getUWIdea().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getUWIdea());
			if (getUWGrade() == null || getUWGrade().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getUWGrade());
			if (getAppGrade() == null || getAppGrade().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getAppGrade());
			if (getPostponeDay() == null || getPostponeDay().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getPostponeDay());
			if (getPostponeDate() == null || getPostponeDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getPostponeDate()));
			if (getAutoUWFlag() == null || getAutoUWFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getAutoUWFlag());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getState());
			if (getUpReportContent() == null || getUpReportContent().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getUpReportContent());
			if (getHealthFlag() == null || getHealthFlag().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getHealthFlag());
			if (getQuesFlag() == null || getQuesFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getQuesFlag());
			if (getSpecFlag() == null || getSpecFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getSpecFlag());
			if (getAddPremFlag() == null || getAddPremFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getAddPremFlag());
			if (getAddPremReason() == null || getAddPremReason().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getAddPremReason());
			if (getReportFlag() == null || getReportFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getReportFlag());
			if (getSpecReason() == null || getSpecReason().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getSpecReason());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(32, 91);
			else
				pstmt.setDate(32, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(34, 91);
			else
				pstmt.setDate(34, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPIndUWMaster WHERE  ContNo = ? AND InsuredId = ?", 1003, 1007);
		if (getContNo() == null || getContNo().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getContNo());
		if (getInsuredId() == null || getInsuredId().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getInsuredId());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_237;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_237;
		CError tError = new CError();
		tError.moduleName = "LNPIndUWMasterDB";
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
				tError.moduleName = "LNPIndUWMasterDB";
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

	public LNPIndUWMasterSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPIndUWMaster");
			LNPIndUWMasterSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPIndUWMasterSchema s1;
			for (; rs.next(); aLNPIndUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPIndUWMasterSchema();
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
			tError.moduleName = "LNPIndUWMasterDB";
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
		return aLNPIndUWMasterSet;
	}

	public LNPIndUWMasterSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPIndUWMasterSchema s1;
			for (; rs.next(); aLNPIndUWMasterSet.add(s1))
			{
				i++;
				s1 = new LNPIndUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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
		return aLNPIndUWMasterSet;
	}

	public LNPIndUWMasterSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPIndUWMaster");
			LNPIndUWMasterSchema aSchema = getSchema();
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
				LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
				s1.setSchema(rs, i);
				aLNPIndUWMasterSet.add(s1);
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
			tError.moduleName = "LNPIndUWMasterDB";
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
		return aLNPIndUWMasterSet;
	}

	public LNPIndUWMasterSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPIndUWMasterSet aLNPIndUWMasterSet = new LNPIndUWMasterSet();
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
				LNPIndUWMasterSchema s1 = new LNPIndUWMasterSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPIndUWMasterDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPIndUWMasterSet.add(s1);
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
			tError.moduleName = "LNPIndUWMasterDB";
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
		return aLNPIndUWMasterSet;
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
				SQLString sqlObj = new SQLString("LNPIndUWMaster");
				LNPIndUWMasterSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPIndUWMaster ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPIndUWMasterDB";
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
				tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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

	public LNPIndUWMasterSet getData()
	{
		int tCount = 0;
		LNPIndUWMasterSet tLNPIndUWMasterSet = new LNPIndUWMasterSet();
		LNPIndUWMasterSchema tLNPIndUWMasterSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
			tLNPIndUWMasterSchema.setSchema(mResultSet, 1);
			tLNPIndUWMasterSet.add(tLNPIndUWMasterSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPIndUWMasterSchema = new LNPIndUWMasterSchema();
					tLNPIndUWMasterSchema.setSchema(mResultSet, 1);
					tLNPIndUWMasterSet.add(tLNPIndUWMasterSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPIndUWMasterDB";
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
		return tLNPIndUWMasterSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
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
				tError.moduleName = "LNPIndUWMasterDB";
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
			tError.moduleName = "LNPIndUWMasterDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
