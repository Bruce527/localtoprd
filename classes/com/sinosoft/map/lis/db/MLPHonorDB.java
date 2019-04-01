// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLPHonorDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MLPHonorSchema;
import com.sinosoft.map.lis.vschema.MLPHonorSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLPHonorDB extends MLPHonorSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MLPHonorDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MLPHonor");
		mflag = true;
	}

	public MLPHonorDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MLPHonor");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MLPHonorSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MLPHonorSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
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
			pstmt = con.prepareStatement("DELETE FROM MLPHonor WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?");
			if (getStatYear() == null || getStatYear().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getStatYear());
			if (getStatBatch() == null || getStatBatch().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getStatBatch());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
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
			pstmt = con.prepareStatement("UPDATE MLPHonor SET  StatYear = ? , StatBatch = ? , AgentCode = ? , ManageCom = ? , BranchType = ? , StartDate = ? , EndDate = ? , Name = ? , EmployDate = ? , BranchAttr = ? , AgentGrade = ? , SMManagerName = ? , AMManagerName = ? , RMManagerName = ? , T1 = ? , T2 = ? , T3 = ? , T4 = ? , T5 = ? , T6 = ? , T7 = ? , T8 = ? , T9 = ? , T10 = ? , T11 = ? , T12 = ? , AMManager = ? , RMManager = ? , SMManager = ? , T13 = ? , T14 = ? , T15 = ? , OutWorkDate = ? , T16 = ? , T17 = ? , T18 = ? , T19 = ? , T20 = ? , T21 = ? , T22 = ? , SMManager2 = ? , RMManager2 = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , C1 = ? , C2 = ? , C3 = ? , C4 = ? , C5 = ? , C6 = ? , C7 = ? , C8 = ? , C9 = ? , C10 = ? WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?");
			if (getStatYear() == null || getStatYear().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getStatYear());
			if (getStatBatch() == null || getStatBatch().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getStatBatch());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchType());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getEndDate()));
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getName());
			if (getEmployDate() == null || getEmployDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getEmployDate()));
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBranchAttr());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAgentGrade());
			if (getSMManagerName() == null || getSMManagerName().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getSMManagerName());
			if (getAMManagerName() == null || getAMManagerName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAMManagerName());
			if (getRMManagerName() == null || getRMManagerName().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRMManagerName());
			pstmt.setDouble(15, getT1());
			pstmt.setDouble(16, getT2());
			pstmt.setDouble(17, getT3());
			pstmt.setDouble(18, getT4());
			pstmt.setDouble(19, getT5());
			pstmt.setDouble(20, getT6());
			if (getT7() == null || getT7().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getT7());
			if (getT8() == null || getT8().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getT8());
			if (getT9() == null || getT9().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getT9());
			pstmt.setDouble(24, getT10());
			pstmt.setDouble(25, getT11());
			pstmt.setDouble(26, getT12());
			if (getAMManager() == null || getAMManager().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getAMManager());
			if (getRMManager() == null || getRMManager().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getRMManager());
			if (getSMManager() == null || getSMManager().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getSMManager());
			if (getT13() == null || getT13().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getT13());
			if (getT14() == null || getT14().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getT14());
			pstmt.setDouble(32, getT15());
			if (getOutWorkDate() == null || getOutWorkDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getOutWorkDate()));
			pstmt.setDouble(34, getT16());
			pstmt.setDouble(35, getT17());
			pstmt.setDouble(36, getT18());
			if (getT19() == null || getT19().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getT19());
			pstmt.setDouble(38, getT20());
			pstmt.setDouble(39, getT21());
			if (getT22() == null || getT22().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getT22());
			if (getSMManager2() == null || getSMManager2().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getSMManager2());
			if (getRMManager2() == null || getRMManager2().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getRMManager2());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getNF01());
			pstmt.setInt(45, getIF01());
			pstmt.setDouble(46, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(47, 91);
			else
				pstmt.setDate(47, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(50, 91);
			else
				pstmt.setDate(50, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(52, 91);
			else
				pstmt.setDate(52, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getModifyTime());
			pstmt.setDouble(54, getC1());
			pstmt.setDouble(55, getC2());
			pstmt.setDouble(56, getC3());
			pstmt.setDouble(57, getC4());
			pstmt.setDouble(58, getC5());
			pstmt.setDouble(59, getC6());
			pstmt.setDouble(60, getC7());
			pstmt.setDouble(61, getC8());
			pstmt.setDouble(62, getC9());
			pstmt.setDouble(63, getC10());
			if (getStatYear() == null || getStatYear().equals("null"))
				pstmt.setNull(64, 12);
			else
				pstmt.setString(64, getStatYear());
			if (getStatBatch() == null || getStatBatch().equals("null"))
				pstmt.setNull(65, 12);
			else
				pstmt.setString(65, getStatBatch());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(66, 12);
			else
				pstmt.setString(66, getAgentCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
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
			pstmt = con.prepareStatement("INSERT INTO MLPHonor VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getStatYear() == null || getStatYear().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getStatYear());
			if (getStatBatch() == null || getStatBatch().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getStatBatch());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAgentCode());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getBranchType());
			if (getStartDate() == null || getStartDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getStartDate()));
			if (getEndDate() == null || getEndDate().equals("null"))
				pstmt.setNull(7, 91);
			else
				pstmt.setDate(7, Date.valueOf(getEndDate()));
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getName());
			if (getEmployDate() == null || getEmployDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getEmployDate()));
			if (getBranchAttr() == null || getBranchAttr().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getBranchAttr());
			if (getAgentGrade() == null || getAgentGrade().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getAgentGrade());
			if (getSMManagerName() == null || getSMManagerName().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getSMManagerName());
			if (getAMManagerName() == null || getAMManagerName().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getAMManagerName());
			if (getRMManagerName() == null || getRMManagerName().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getRMManagerName());
			pstmt.setDouble(15, getT1());
			pstmt.setDouble(16, getT2());
			pstmt.setDouble(17, getT3());
			pstmt.setDouble(18, getT4());
			pstmt.setDouble(19, getT5());
			pstmt.setDouble(20, getT6());
			if (getT7() == null || getT7().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getT7());
			if (getT8() == null || getT8().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getT8());
			if (getT9() == null || getT9().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getT9());
			pstmt.setDouble(24, getT10());
			pstmt.setDouble(25, getT11());
			pstmt.setDouble(26, getT12());
			if (getAMManager() == null || getAMManager().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getAMManager());
			if (getRMManager() == null || getRMManager().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getRMManager());
			if (getSMManager() == null || getSMManager().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getSMManager());
			if (getT13() == null || getT13().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getT13());
			if (getT14() == null || getT14().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getT14());
			pstmt.setDouble(32, getT15());
			if (getOutWorkDate() == null || getOutWorkDate().equals("null"))
				pstmt.setNull(33, 91);
			else
				pstmt.setDate(33, Date.valueOf(getOutWorkDate()));
			pstmt.setDouble(34, getT16());
			pstmt.setDouble(35, getT17());
			pstmt.setDouble(36, getT18());
			if (getT19() == null || getT19().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getT19());
			pstmt.setDouble(38, getT20());
			pstmt.setDouble(39, getT21());
			if (getT22() == null || getT22().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getT22());
			if (getSMManager2() == null || getSMManager2().equals("null"))
				pstmt.setNull(41, 12);
			else
				pstmt.setString(41, getSMManager2());
			if (getRMManager2() == null || getRMManager2().equals("null"))
				pstmt.setNull(42, 12);
			else
				pstmt.setString(42, getRMManager2());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(43, 12);
			else
				pstmt.setString(43, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(44, 12);
			else
				pstmt.setString(44, getNF01());
			pstmt.setInt(45, getIF01());
			pstmt.setDouble(46, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(47, 91);
			else
				pstmt.setDate(47, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(48, 12);
			else
				pstmt.setString(48, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(49, 12);
			else
				pstmt.setString(49, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(50, 91);
			else
				pstmt.setDate(50, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(51, 12);
			else
				pstmt.setString(51, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(52, 91);
			else
				pstmt.setDate(52, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(53, 12);
			else
				pstmt.setString(53, getModifyTime());
			pstmt.setDouble(54, getC1());
			pstmt.setDouble(55, getC2());
			pstmt.setDouble(56, getC3());
			pstmt.setDouble(57, getC4());
			pstmt.setDouble(58, getC5());
			pstmt.setDouble(59, getC6());
			pstmt.setDouble(60, getC7());
			pstmt.setDouble(61, getC8());
			pstmt.setDouble(62, getC9());
			pstmt.setDouble(63, getC10());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MLPHonor WHERE  StatYear = ? AND StatBatch = ? AND AgentCode = ?", 1003, 1007);
		if (getStatYear() == null || getStatYear().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getStatYear());
		if (getStatBatch() == null || getStatBatch().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getStatBatch());
		if (getAgentCode() == null || getAgentCode().equals("null"))
			pstmt.setNull(3, 12);
		else
			pstmt.setString(3, getAgentCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_279;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_279;
		CError tError = new CError();
		tError.moduleName = "MLPHonorDB";
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
				tError.moduleName = "MLPHonorDB";
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

	public MLPHonorSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLPHonorSet aMLPHonorSet = new MLPHonorSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLPHonor");
			MLPHonorSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MLPHonorSchema s1;
			for (; rs.next(); aMLPHonorSet.add(s1))
			{
				i++;
				s1 = new MLPHonorSchema();
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
			tError.moduleName = "MLPHonorDB";
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
		return aMLPHonorSet;
	}

	public MLPHonorSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLPHonorSet aMLPHonorSet = new MLPHonorSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MLPHonorSchema s1;
			for (; rs.next(); aMLPHonorSet.add(s1))
			{
				i++;
				s1 = new MLPHonorSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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
		return aMLPHonorSet;
	}

	public MLPHonorSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLPHonorSet aMLPHonorSet = new MLPHonorSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLPHonor");
			MLPHonorSchema aSchema = getSchema();
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
				MLPHonorSchema s1 = new MLPHonorSchema();
				s1.setSchema(rs, i);
				aMLPHonorSet.add(s1);
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
			tError.moduleName = "MLPHonorDB";
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
		return aMLPHonorSet;
	}

	public MLPHonorSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLPHonorSet aMLPHonorSet = new MLPHonorSet();
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
				MLPHonorSchema s1 = new MLPHonorSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLPHonorDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aMLPHonorSet.add(s1);
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
			tError.moduleName = "MLPHonorDB";
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
		return aMLPHonorSet;
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
				SQLString sqlObj = new SQLString("MLPHonor");
				MLPHonorSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MLPHonor ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MLPHonorDB";
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
				tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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

	public MLPHonorSet getData()
	{
		int tCount = 0;
		MLPHonorSet tMLPHonorSet = new MLPHonorSet();
		MLPHonorSchema tMLPHonorSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMLPHonorSchema = new MLPHonorSchema();
			tMLPHonorSchema.setSchema(mResultSet, 1);
			tMLPHonorSet.add(tMLPHonorSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMLPHonorSchema = new MLPHonorSchema();
					tMLPHonorSchema.setSchema(mResultSet, 1);
					tMLPHonorSet.add(tMLPHonorSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLPHonorDB";
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
		return tMLPHonorSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
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
				tError.moduleName = "MLPHonorDB";
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
			tError.moduleName = "MLPHonorDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
