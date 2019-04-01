// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLinkBDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MLinkBSchema;
import com.sinosoft.map.lis.vschema.MLinkBSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MLinkBDB extends MLinkBSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MLinkBDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MLinkB");
		mflag = true;
	}

	public MLinkBDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MLinkB");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MLinkBSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MLinkBSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
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
			pstmt = con.prepareStatement("DELETE FROM MLinkB WHERE  EdorNo = ?");
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
			tError.moduleName = "MLinkBDB";
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
			pstmt = con.prepareStatement("UPDATE MLinkB SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , AgentCode = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getRefURL() == null || getRefURL().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRefURL());
			if (getTarget() == null || getTarget().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getTarget());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getName());
			pstmt.setInt(5, getLinkOrder());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getState());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentCode());
			if (getIcon() == null || getIcon().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getIcon());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getBranchType());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getNF01());
			pstmt.setInt(14, getIF01());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getModifyTime());
			if (getDescription() == null || getDescription().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getDescription());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getOperator2());
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getMakeTime2());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getEdorNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
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
			pstmt = con.prepareStatement("INSERT INTO MLinkB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getID() == null || getID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getID());
			if (getRefURL() == null || getRefURL().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getRefURL());
			if (getTarget() == null || getTarget().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getTarget());
			if (getName() == null || getName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getName());
			pstmt.setInt(5, getLinkOrder());
			if (getState() == null || getState().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getState());
			if (getType() == null || getType().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getType());
			if (getAgentCode() == null || getAgentCode().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAgentCode());
			if (getIcon() == null || getIcon().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getIcon());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getBranchType());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getNF01());
			pstmt.setInt(14, getIF01());
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getOperator());
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getMakeTime());
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getModifyTime());
			if (getDescription() == null || getDescription().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getDescription());
			if (getEdorNo() == null || getEdorNo().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getEdorNo());
			if (getEdorType() == null || getEdorType().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getEdorType());
			if (getEdorCase() == null || getEdorCase().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getEdorCase());
			if (getOperator2() == null || getOperator2().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getOperator2());
			if (getMakeTime2() == null || getMakeTime2().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getMakeTime2());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MLinkB WHERE  EdorNo = ?", 1003, 1007);
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
		tError.moduleName = "MLinkBDB";
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
				tError.moduleName = "MLinkBDB";
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

	public MLinkBSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLinkBSet aMLinkBSet = new MLinkBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLinkB");
			MLinkBSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MLinkBSchema s1;
			for (; rs.next(); aMLinkBSet.add(s1))
			{
				i++;
				s1 = new MLinkBSchema();
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
			tError.moduleName = "MLinkBDB";
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
		return aMLinkBSet;
	}

	public MLinkBSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLinkBSet aMLinkBSet = new MLinkBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MLinkBSchema s1;
			for (; rs.next(); aMLinkBSet.add(s1))
			{
				i++;
				s1 = new MLinkBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLinkBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�������ֶ�����Ϣ!";
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
			tError.moduleName = "MLinkBDB";
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
		return aMLinkBSet;
	}

	public MLinkBSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLinkBSet aMLinkBSet = new MLinkBSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MLinkB");
			MLinkBSchema aSchema = getSchema();
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
				MLinkBSchema s1 = new MLinkBSchema();
				s1.setSchema(rs, i);
				aMLinkBSet.add(s1);
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
			tError.moduleName = "MLinkBDB";
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
		return aMLinkBSet;
	}

	public MLinkBSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MLinkBSet aMLinkBSet = new MLinkBSet();
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
				MLinkBSchema s1 = new MLinkBSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MLinkBDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�������ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aMLinkBSet.add(s1);
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
			tError.moduleName = "MLinkBDB";
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
		return aMLinkBSet;
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
				SQLString sqlObj = new SQLString("MLinkB");
				MLinkBSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MLinkB ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MLinkBDB";
				tError.functionName = "update";
				tError.errorMessage = "��������ʧ��!";
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
				tError.moduleName = "MLinkBDB";
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
			tError.moduleName = "MLinkBDB";
			tError.functionName = "prepareData";
			tError.errorMessage = "���ݼ��ǿգ�������׼�����ݼ�֮��û�йرգ�";
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
			tError.moduleName = "MLinkBDB";
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
			tError.moduleName = "MLinkBDB";
			tError.functionName = "hasMoreData";
			tError.errorMessage = "���ݼ�Ϊ�գ�����׼�����ݼ���";
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
			tError.moduleName = "MLinkBDB";
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

	public MLinkBSet getData()
	{
		int tCount = 0;
		MLinkBSet tMLinkBSet = new MLinkBSet();
		MLinkBSchema tMLinkBSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
			tError.functionName = "getData";
			tError.errorMessage = "���ݼ�Ϊ�գ�����׼�����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMLinkBSchema = new MLinkBSchema();
			tMLinkBSchema.setSchema(mResultSet, 1);
			tMLinkBSet.add(tMLinkBSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMLinkBSchema = new MLinkBSchema();
					tMLinkBSchema.setSchema(mResultSet, 1);
					tMLinkBSet.add(tMLinkBSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MLinkBDB";
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
		return tMLinkBSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MLinkBDB";
				tError.functionName = "closeData";
				tError.errorMessage = "���ݼ��Ѿ��ر��ˣ�";
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
			tError.moduleName = "MLinkBDB";
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
				tError.moduleName = "MLinkBDB";
				tError.functionName = "closeData";
				tError.errorMessage = "����Ѿ��ر��ˣ�";
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
			tError.moduleName = "MLinkBDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
