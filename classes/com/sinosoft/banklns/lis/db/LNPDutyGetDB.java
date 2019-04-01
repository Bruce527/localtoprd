// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPDutyGetDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPDutyGetSchema;
import com.sinosoft.banklns.lis.vschema.LNPDutyGetSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPDutyGetDB extends LNPDutyGetSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPDutyGetDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPDutyGet");
		mflag = true;
	}

	public LNPDutyGetDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPDutyGet");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPDutyGetSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPDutyGetSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPDutyGet WHERE  GetDutyCode = ?");
			if (getGetDutyCode() == null || getGetDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGetDutyCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
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
			pstmt = con.prepareStatement("UPDATE LNPDutyGet SET  GetDutyCode = ? , GetDutyName = ? , Type = ? , GetIntv = ? , DefaultVal = ? , CalCode = ? , CnterCalCode = ? , OthCalCode = ? , GetYear = ? , GetYearFlag = ? , StartDateCalRef = ? , StartDateCalMode = ? , MinGetStartPeriod = ? , GetEndPeriod = ? , GetEndUnit = ? , EndDateCalRef = ? , EndDateCalMode = ? , MaxGetEndPeriod = ? , AddFlag = ? , SexRelaFlag = ? , UnitAppRelaFlag = ? , AddAmntFlag = ? , DiscntFlag = ? , InterestFlag = ? , ShareFlag = ? , InpFlag = ? , BnfFlag = ? , UrgeGetFlag = ? , DeadValiFlag = ? , GetInitFlag = ? , GetLimit = ? , MaxGet = ? , GetRate = ? , NeedAcc = ? , CanGet = ? , NeedCancelAcc = ? , GetType1 = ? , ZeroFlag = ? , GetType2 = ? WHERE  GetDutyCode = ?");
			if (getGetDutyCode() == null || getGetDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGetDutyCode());
			if (getGetDutyName() == null || getGetDutyName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGetDutyName());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getType());
			pstmt.setInt(4, getGetIntv());
			pstmt.setDouble(5, getDefaultVal());
			if (getCalCode() == null || getCalCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getCalCode());
			if (getCnterCalCode() == null || getCnterCalCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCnterCalCode());
			if (getOthCalCode() == null || getOthCalCode().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOthCalCode());
			pstmt.setInt(9, getGetYear());
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getGetYearFlag());
			if (getStartDateCalRef() == null || getStartDateCalRef().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getStartDateCalRef());
			if (getStartDateCalMode() == null || getStartDateCalMode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getStartDateCalMode());
			pstmt.setInt(13, getMinGetStartPeriod());
			pstmt.setInt(14, getGetEndPeriod());
			if (getGetEndUnit() == null || getGetEndUnit().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getGetEndUnit());
			if (getEndDateCalRef() == null || getEndDateCalRef().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getEndDateCalRef());
			if (getEndDateCalMode() == null || getEndDateCalMode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getEndDateCalMode());
			pstmt.setInt(18, getMaxGetEndPeriod());
			if (getAddFlag() == null || getAddFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAddFlag());
			if (getSexRelaFlag() == null || getSexRelaFlag().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSexRelaFlag());
			if (getUnitAppRelaFlag() == null || getUnitAppRelaFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getUnitAppRelaFlag());
			if (getAddAmntFlag() == null || getAddAmntFlag().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAddAmntFlag());
			if (getDiscntFlag() == null || getDiscntFlag().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getDiscntFlag());
			if (getInterestFlag() == null || getInterestFlag().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getInterestFlag());
			if (getShareFlag() == null || getShareFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getShareFlag());
			if (getInpFlag() == null || getInpFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getInpFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getBnfFlag());
			if (getUrgeGetFlag() == null || getUrgeGetFlag().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getUrgeGetFlag());
			if (getDeadValiFlag() == null || getDeadValiFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getDeadValiFlag());
			if (getGetInitFlag() == null || getGetInitFlag().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getGetInitFlag());
			pstmt.setDouble(31, getGetLimit());
			pstmt.setDouble(32, getMaxGet());
			pstmt.setDouble(33, getGetRate());
			if (getNeedAcc() == null || getNeedAcc().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getNeedAcc());
			if (getCanGet() == null || getCanGet().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getCanGet());
			if (getNeedCancelAcc() == null || getNeedCancelAcc().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getNeedCancelAcc());
			if (getGetType1() == null || getGetType1().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getGetType1());
			if (getZeroFlag() == null || getZeroFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getZeroFlag());
			if (getGetType2() == null || getGetType2().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getGetType2());
			if (getGetDutyCode() == null || getGetDutyCode().equals("null"))
				pstmt.setNull(40, 12);
			else
				pstmt.setString(40, getGetDutyCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPDutyGet VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getGetDutyCode() == null || getGetDutyCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getGetDutyCode());
			if (getGetDutyName() == null || getGetDutyName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getGetDutyName());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getType());
			pstmt.setInt(4, getGetIntv());
			pstmt.setDouble(5, getDefaultVal());
			if (getCalCode() == null || getCalCode().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getCalCode());
			if (getCnterCalCode() == null || getCnterCalCode().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCnterCalCode());
			if (getOthCalCode() == null || getOthCalCode().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getOthCalCode());
			pstmt.setInt(9, getGetYear());
			if (getGetYearFlag() == null || getGetYearFlag().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getGetYearFlag());
			if (getStartDateCalRef() == null || getStartDateCalRef().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getStartDateCalRef());
			if (getStartDateCalMode() == null || getStartDateCalMode().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getStartDateCalMode());
			pstmt.setInt(13, getMinGetStartPeriod());
			pstmt.setInt(14, getGetEndPeriod());
			if (getGetEndUnit() == null || getGetEndUnit().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getGetEndUnit());
			if (getEndDateCalRef() == null || getEndDateCalRef().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getEndDateCalRef());
			if (getEndDateCalMode() == null || getEndDateCalMode().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getEndDateCalMode());
			pstmt.setInt(18, getMaxGetEndPeriod());
			if (getAddFlag() == null || getAddFlag().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getAddFlag());
			if (getSexRelaFlag() == null || getSexRelaFlag().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getSexRelaFlag());
			if (getUnitAppRelaFlag() == null || getUnitAppRelaFlag().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getUnitAppRelaFlag());
			if (getAddAmntFlag() == null || getAddAmntFlag().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getAddAmntFlag());
			if (getDiscntFlag() == null || getDiscntFlag().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getDiscntFlag());
			if (getInterestFlag() == null || getInterestFlag().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getInterestFlag());
			if (getShareFlag() == null || getShareFlag().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getShareFlag());
			if (getInpFlag() == null || getInpFlag().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getInpFlag());
			if (getBnfFlag() == null || getBnfFlag().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getBnfFlag());
			if (getUrgeGetFlag() == null || getUrgeGetFlag().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getUrgeGetFlag());
			if (getDeadValiFlag() == null || getDeadValiFlag().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getDeadValiFlag());
			if (getGetInitFlag() == null || getGetInitFlag().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getGetInitFlag());
			pstmt.setDouble(31, getGetLimit());
			pstmt.setDouble(32, getMaxGet());
			pstmt.setDouble(33, getGetRate());
			if (getNeedAcc() == null || getNeedAcc().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getNeedAcc());
			if (getCanGet() == null || getCanGet().equals("null"))
				pstmt.setNull(35, 12);
			else
				pstmt.setString(35, getCanGet());
			if (getNeedCancelAcc() == null || getNeedCancelAcc().equals("null"))
				pstmt.setNull(36, 12);
			else
				pstmt.setString(36, getNeedCancelAcc());
			if (getGetType1() == null || getGetType1().equals("null"))
				pstmt.setNull(37, 12);
			else
				pstmt.setString(37, getGetType1());
			if (getZeroFlag() == null || getZeroFlag().equals("null"))
				pstmt.setNull(38, 12);
			else
				pstmt.setString(38, getZeroFlag());
			if (getGetType2() == null || getGetType2().equals("null"))
				pstmt.setNull(39, 12);
			else
				pstmt.setString(39, getGetType2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPDutyGet WHERE  GetDutyCode = ?", 1003, 1007);
		if (getGetDutyCode() == null || getGetDutyCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getGetDutyCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "LNPDutyGetDB";
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
				tError.moduleName = "LNPDutyGetDB";
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

	public LNPDutyGetSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPDutyGet");
			LNPDutyGetSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPDutyGetSchema s1;
			for (; rs.next(); aLNPDutyGetSet.add(s1))
			{
				i++;
				s1 = new LNPDutyGetSchema();
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
			tError.moduleName = "LNPDutyGetDB";
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
		return aLNPDutyGetSet;
	}

	public LNPDutyGetSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPDutyGetSchema s1;
			for (; rs.next(); aLNPDutyGetSet.add(s1))
			{
				i++;
				s1 = new LNPDutyGetSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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
		return aLNPDutyGetSet;
	}

	public LNPDutyGetSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPDutyGet");
			LNPDutyGetSchema aSchema = getSchema();
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
				LNPDutyGetSchema s1 = new LNPDutyGetSchema();
				s1.setSchema(rs, i);
				aLNPDutyGetSet.add(s1);
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
			tError.moduleName = "LNPDutyGetDB";
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
		return aLNPDutyGetSet;
	}

	public LNPDutyGetSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPDutyGetSet aLNPDutyGetSet = new LNPDutyGetSet();
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
				LNPDutyGetSchema s1 = new LNPDutyGetSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPDutyGetDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPDutyGetSet.add(s1);
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
			tError.moduleName = "LNPDutyGetDB";
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
		return aLNPDutyGetSet;
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
				SQLString sqlObj = new SQLString("LNPDutyGet");
				LNPDutyGetSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPDutyGet ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPDutyGetDB";
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
				tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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

	public LNPDutyGetSet getData()
	{
		int tCount = 0;
		LNPDutyGetSet tLNPDutyGetSet = new LNPDutyGetSet();
		LNPDutyGetSchema tLNPDutyGetSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPDutyGetSchema = new LNPDutyGetSchema();
			tLNPDutyGetSchema.setSchema(mResultSet, 1);
			tLNPDutyGetSet.add(tLNPDutyGetSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPDutyGetSchema = new LNPDutyGetSchema();
					tLNPDutyGetSchema.setSchema(mResultSet, 1);
					tLNPDutyGetSet.add(tLNPDutyGetSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPDutyGetDB";
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
		return tLNPDutyGetSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
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
				tError.moduleName = "LNPDutyGetDB";
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
			tError.moduleName = "LNPDutyGetDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
