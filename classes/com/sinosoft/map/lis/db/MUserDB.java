// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MUserSchema;
import com.sinosoft.map.lis.vschema.MUserSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MUserDB extends MUserSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MUserDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MUser");
		mflag = true;
	}

	public MUserDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MUser");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MUserSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MUserSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserDB";
			tError.functionName = "getCount";
			tError.errorMessage = "����ʧ��!";
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
			pstmt = con.prepareStatement("DELETE FROM MUser WHERE  UserCode = ?");
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getUserCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserDB";
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
			pstmt = con.prepareStatement("UPDATE MUser SET  UserCode = ? , UserName = ? , ManageCom = ? , BranchType = ? , Password = ? , PwdModifyDate = ? , UserDescription = ? , UserState = ? , SuperPopedomFlag = ? , ValidStartDate = ? , ValidEndDate = ? , StuffNo = ? , OfficePhone = ? , Phone = ? , EMail = ? , Operator = ? , ModifyOperator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  UserCode = ?");
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getUserCode());
			if (getUserName() == null || getUserName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getUserName());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getBranchType());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPassword());
			if (getPwdModifyDate() == null || getPwdModifyDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getPwdModifyDate()));
			if (getUserDescription() == null || getUserDescription().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getUserDescription());
			if (getUserState() == null || getUserState().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getUserState());
			if (getSuperPopedomFlag() == null || getSuperPopedomFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getSuperPopedomFlag());
			if (getValidStartDate() == null || getValidStartDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getValidStartDate()));
			if (getValidEndDate() == null || getValidEndDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getValidEndDate()));
			if (getStuffNo() == null || getStuffNo().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getStuffNo());
			if (getOfficePhone() == null || getOfficePhone().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getOfficePhone());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getPhone());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getEMail());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getModifyTime());
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getUserCode());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserDB";
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
			pstmt = con.prepareStatement("INSERT INTO MUser VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getUserCode());
			if (getUserName() == null || getUserName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getUserName());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getBranchType());
			if (getPassword() == null || getPassword().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getPassword());
			if (getPwdModifyDate() == null || getPwdModifyDate().equals("null"))
				pstmt.setNull(6, 91);
			else
				pstmt.setDate(6, Date.valueOf(getPwdModifyDate()));
			if (getUserDescription() == null || getUserDescription().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getUserDescription());
			if (getUserState() == null || getUserState().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getUserState());
			if (getSuperPopedomFlag() == null || getSuperPopedomFlag().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getSuperPopedomFlag());
			if (getValidStartDate() == null || getValidStartDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getValidStartDate()));
			if (getValidEndDate() == null || getValidEndDate().equals("null"))
				pstmt.setNull(11, 91);
			else
				pstmt.setDate(11, Date.valueOf(getValidEndDate()));
			if (getStuffNo() == null || getStuffNo().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getStuffNo());
			if (getOfficePhone() == null || getOfficePhone().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getOfficePhone());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getPhone());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getEMail());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getOperator());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(20, 91);
			else
				pstmt.setDate(20, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getModifyTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MUser WHERE  UserCode = ?", 1003, 1007);
		if (getUserCode() == null || getUserCode().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getUserCode());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_193;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_193;
		CError tError = new CError();
		tError.moduleName = "MUserDB";
		tError.functionName = "getInfo";
		tError.errorMessage = "ȡ��ʧ��!";
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
				tError.moduleName = "MUserDB";
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

	public MUserSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserSet aMUserSet = new MUserSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MUser");
			MUserSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MUserSchema s1;
			for (; rs.next(); aMUserSet.add(s1))
			{
				i++;
				s1 = new MUserSchema();
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
			tError.moduleName = "MUserDB";
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
		return aMUserSet;
	}

	public MUserSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserSet aMUserSet = new MUserSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MUserSchema s1;
			for (; rs.next(); aMUserSet.add(s1))
			{
				i++;
				s1 = new MUserSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MUserDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
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
			tError.moduleName = "MUserDB";
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
		return aMUserSet;
	}

	public MUserSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserSet aMUserSet = new MUserSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MUser");
			MUserSchema aSchema = getSchema();
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
				MUserSchema s1 = new MUserSchema();
				s1.setSchema(rs, i);
				aMUserSet.add(s1);
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
			tError.moduleName = "MUserDB";
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
		return aMUserSet;
	}

	public MUserSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserSet aMUserSet = new MUserSet();
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
				MUserSchema s1 = new MUserSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MUserDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aMUserSet.add(s1);
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
			tError.moduleName = "MUserDB";
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
		return aMUserSet;
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
				SQLString sqlObj = new SQLString("MUser");
				MUserSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MUser ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MUserDB";
				tError.functionName = "update";
				tError.errorMessage = "�������ʧ��?!";
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
				tError.moduleName = "MUserDB";
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
			tError.moduleName = "MUserDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "��ݼ��ǿգ�������׼����ݼ�֮��û�йرգ�";
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
			tError.moduleName = "MUserDB";
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
			tError.moduleName = "MUserDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
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
			tError.moduleName = "MUserDB";
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

	public MUserSet getData()
	{
		int tCount = 0;
		MUserSet tMUserSet = new MUserSet();
		MUserSchema tMUserSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MUserDB";
			tError.functionName = "getData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMUserSchema = new MUserSchema();
			tMUserSchema.setSchema(mResultSet, 1);
			tMUserSet.add(tMUserSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMUserSchema = new MUserSchema();
					tMUserSchema.setSchema(mResultSet, 1);
					tMUserSet.add(tMUserSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MUserDB";
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
		return tMUserSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MUserDB";
				tError.functionName = "closeData";
				tError.errorMessage = "��ݼ��Ѿ��ر��ˣ�?";
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
			tError.moduleName = "MUserDB";
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
				tError.moduleName = "MUserDB";
				tError.functionName = "closeData";
				tError.errorMessage = "����Ѿ��ر��ˣ�?";
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
			tError.moduleName = "MUserDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
