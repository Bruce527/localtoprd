// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MUserLogDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MUserLogSchema;
import com.sinosoft.map.lis.vschema.MUserLogSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MUserLogDB extends MUserLogSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MUserLogDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MUserLog");
		mflag = true;
	}

	public MUserLogDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MUserLog");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MUserLogSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MUserLogSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
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
			pstmt = con.prepareStatement("DELETE FROM MUserLog WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
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
			pstmt = con.prepareStatement("UPDATE MUserLog SET  ID = ? , UserCode = ? , UserType = ? , TraceType = ? , MenuID = ? , MenuName = ? , Operation = ? , Discription = ? , CientIP = ? , MakeDate = ? , MakeTime = ? WHERE  ID = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getUserCode());
			if (getUserType() == null || getUserType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getUserType());
			if (getTraceType() == null || getTraceType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getTraceType());
			if (getMenuID() == null || getMenuID().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMenuID());
			if (getMenuName() == null || getMenuName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMenuName());
			if (getOperation() == null || getOperation().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getOperation());
			if (getDiscription() == null || getDiscription().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDiscription());
			if (getCientIP() == null || getCientIP().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCientIP());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMakeTime());
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
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
			pstmt = con.prepareStatement("INSERT INTO MUserLog VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getUserCode() == null || getUserCode().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getUserCode());
			if (getUserType() == null || getUserType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getUserType());
			if (getTraceType() == null || getTraceType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getTraceType());
			if (getMenuID() == null || getMenuID().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getMenuID());
			if (getMenuName() == null || getMenuName().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getMenuName());
			if (getOperation() == null || getOperation().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getOperation());
			if (getDiscription() == null || getDiscription().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDiscription());
			if (getCientIP() == null || getCientIP().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCientIP());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getMakeTime());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MUserLog WHERE  ID = ?", 1003, 1007);
		if (getID() == null || getID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_192;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_192;
		CError tError = new CError();
		tError.moduleName = "MUserLogDB";
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
				tError.moduleName = "MUserLogDB";
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

	public MUserLogSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserLogSet aMUserLogSet = new MUserLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MUserLog");
			MUserLogSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MUserLogSchema s1;
			for (; rs.next(); aMUserLogSet.add(s1))
			{
				i++;
				s1 = new MUserLogSchema();
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
			tError.moduleName = "MUserLogDB";
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
		return aMUserLogSet;
	}

	public MUserLogSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserLogSet aMUserLogSet = new MUserLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MUserLogSchema s1;
			for (; rs.next(); aMUserLogSet.add(s1))
			{
				i++;
				s1 = new MUserLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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
		return aMUserLogSet;
	}

	public MUserLogSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserLogSet aMUserLogSet = new MUserLogSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MUserLog");
			MUserLogSchema aSchema = getSchema();
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
				MUserLogSchema s1 = new MUserLogSchema();
				s1.setSchema(rs, i);
				aMUserLogSet.add(s1);
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
			tError.moduleName = "MUserLogDB";
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
		return aMUserLogSet;
	}

	public MUserLogSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MUserLogSet aMUserLogSet = new MUserLogSet();
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
				MUserLogSchema s1 = new MUserLogSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MUserLogDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aMUserLogSet.add(s1);
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
			tError.moduleName = "MUserLogDB";
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
		return aMUserLogSet;
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
				SQLString sqlObj = new SQLString("MUserLog");
				MUserLogSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MUserLog ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MUserLogDB";
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
				tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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

	public MUserLogSet getData()
	{
		int tCount = 0;
		MUserLogSet tMUserLogSet = new MUserLogSet();
		MUserLogSchema tMUserLogSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
			tError.functionName = "getData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMUserLogSchema = new MUserLogSchema();
			tMUserLogSchema.setSchema(mResultSet, 1);
			tMUserLogSet.add(tMUserLogSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMUserLogSchema = new MUserLogSchema();
					tMUserLogSchema.setSchema(mResultSet, 1);
					tMUserLogSet.add(tMUserLogSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MUserLogDB";
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
		return tMUserLogSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
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
				tError.moduleName = "MUserLogDB";
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
			tError.moduleName = "MUserLogDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
