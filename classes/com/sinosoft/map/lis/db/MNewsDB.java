// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsDB.java

package com.sinosoft.map.lis.db;

import com.sinosoft.map.lis.schema.MNewsSchema;
import com.sinosoft.map.lis.vschema.MNewsSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MNewsDB extends MNewsSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public MNewsDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "MNews");
		mflag = true;
	}

	public MNewsDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("MNews");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		MNewsSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		MNewsSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
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
			pstmt = con.prepareStatement("DELETE FROM MNews WHERE  NewsID = ?");
			if (getNewsID() == null || getNewsID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNewsID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
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
			pstmt = con.prepareStatement("UPDATE MNews SET  NewsID = ? , ManageCom = ? , BranchType = ? , NewsType = ? , Title = ? , Subhead = ? , Brief = ? , Author = ? , StartDisplayDate = ? , EndDisplayDate = ? , StartDisplayTime = ? , EndDisplayTime = ? , StaticPageURL = ? , MinDisplayGrade = ? , CheckState = ? , CheckOperator = ? , CheckReason = ? , CheckDate = ? , CheckTime = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , ClickRate = ? , FixedTop = ? WHERE  NewsID = ?");
			if (getNewsID() == null || getNewsID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNewsID());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getBranchType());
			if (getNewsType() == null || getNewsType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getNewsType());
			if (getTitle() == null || getTitle().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getTitle());
			if (getSubhead() == null || getSubhead().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getSubhead());
			if (getBrief() == null || getBrief().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getBrief());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAuthor());
			if (getStartDisplayDate() == null || getStartDisplayDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getStartDisplayDate()));
			if (getEndDisplayDate() == null || getEndDisplayDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getEndDisplayDate()));
			if (getStartDisplayTime() == null || getStartDisplayTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getStartDisplayTime());
			if (getEndDisplayTime() == null || getEndDisplayTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getEndDisplayTime());
			if (getStaticPageURL() == null || getStaticPageURL().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getStaticPageURL());
			if (getMinDisplayGrade() == null || getMinDisplayGrade().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getMinDisplayGrade());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getNF01());
			pstmt.setInt(22, getIF01());
			pstmt.setDouble(23, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(29, 91);
			else
				pstmt.setDate(29, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getModifyTime());
			pstmt.setInt(31, getClickRate());
			pstmt.setInt(32, getFixedTop());
			if (getNewsID() == null || getNewsID().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getNewsID());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
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
			pstmt = con.prepareStatement("INSERT INTO MNews VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getNewsID() == null || getNewsID().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getNewsID());
			if (getManageCom() == null || getManageCom().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getManageCom());
			if (getBranchType() == null || getBranchType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getBranchType());
			if (getNewsType() == null || getNewsType().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getNewsType());
			if (getTitle() == null || getTitle().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getTitle());
			if (getSubhead() == null || getSubhead().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getSubhead());
			if (getBrief() == null || getBrief().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getBrief());
			if (getAuthor() == null || getAuthor().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getAuthor());
			if (getStartDisplayDate() == null || getStartDisplayDate().equals("null"))
				pstmt.setNull(9, 91);
			else
				pstmt.setDate(9, Date.valueOf(getStartDisplayDate()));
			if (getEndDisplayDate() == null || getEndDisplayDate().equals("null"))
				pstmt.setNull(10, 91);
			else
				pstmt.setDate(10, Date.valueOf(getEndDisplayDate()));
			if (getStartDisplayTime() == null || getStartDisplayTime().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getStartDisplayTime());
			if (getEndDisplayTime() == null || getEndDisplayTime().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getEndDisplayTime());
			if (getStaticPageURL() == null || getStaticPageURL().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getStaticPageURL());
			if (getMinDisplayGrade() == null || getMinDisplayGrade().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getMinDisplayGrade());
			if (getCheckState() == null || getCheckState().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCheckState());
			if (getCheckOperator() == null || getCheckOperator().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCheckOperator());
			if (getCheckReason() == null || getCheckReason().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCheckReason());
			if (getCheckDate() == null || getCheckDate().equals("null"))
				pstmt.setNull(18, 91);
			else
				pstmt.setDate(18, Date.valueOf(getCheckDate()));
			if (getCheckTime() == null || getCheckTime().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getCheckTime());
			if (getVF01() == null || getVF01().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getVF01());
			if (getNF01() == null || getNF01().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getNF01());
			pstmt.setInt(22, getIF01());
			pstmt.setDouble(23, getDF02());
			if (getDate01() == null || getDate01().equals("null"))
				pstmt.setNull(24, 91);
			else
				pstmt.setDate(24, Date.valueOf(getDate01()));
			if (getModifyOperator() == null || getModifyOperator().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getModifyOperator());
			if (getOperator() == null || getOperator().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getOperator());
			if (getMakeDate() == null || getMakeDate().equals("null"))
				pstmt.setNull(27, 91);
			else
				pstmt.setDate(27, Date.valueOf(getMakeDate()));
			if (getMakeTime() == null || getMakeTime().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getMakeTime());
			if (getModifyDate() == null || getModifyDate().equals("null"))
				pstmt.setNull(29, 91);
			else
				pstmt.setDate(29, Date.valueOf(getModifyDate()));
			if (getModifyTime() == null || getModifyTime().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getModifyTime());
			pstmt.setInt(31, getClickRate());
			pstmt.setInt(32, getFixedTop());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
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
		pstmt = con.prepareStatement("SELECT * FROM MNews WHERE  NewsID = ?", 1003, 1007);
		if (getNewsID() == null || getNewsID().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getNewsID());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_195;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_195;
		CError tError = new CError();
		tError.moduleName = "MNewsDB";
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
				tError.moduleName = "MNewsDB";
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

	public MNewsSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewsSet aMNewsSet = new MNewsSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MNews");
			MNewsSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			MNewsSchema s1;
			for (; rs.next(); aMNewsSet.add(s1))
			{
				i++;
				s1 = new MNewsSchema();
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
			tError.moduleName = "MNewsDB";
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
		return aMNewsSet;
	}

	public MNewsSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewsSet aMNewsSet = new MNewsSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			MNewsSchema s1;
			for (; rs.next(); aMNewsSet.add(s1))
			{
				i++;
				s1 = new MNewsSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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
		return aMNewsSet;
	}

	public MNewsSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewsSet aMNewsSet = new MNewsSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("MNews");
			MNewsSchema aSchema = getSchema();
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
				MNewsSchema s1 = new MNewsSchema();
				s1.setSchema(rs, i);
				aMNewsSet.add(s1);
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
			tError.moduleName = "MNewsDB";
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
		return aMNewsSet;
	}

	public MNewsSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		MNewsSet aMNewsSet = new MNewsSet();
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
				MNewsSchema s1 = new MNewsSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "MNewsDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql���������鿴�����ֶ�����Ϣ!";
					mErrors.addOneError(tError);
				}
				aMNewsSet.add(s1);
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
			tError.moduleName = "MNewsDB";
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
		return aMNewsSet;
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
				SQLString sqlObj = new SQLString("MNews");
				MNewsSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update MNews ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "MNewsDB";
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
				tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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

	public MNewsSet getData()
	{
		int tCount = 0;
		MNewsSet tMNewsSet = new MNewsSet();
		MNewsSchema tMNewsSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
			tError.functionName = "getData";
			tError.errorMessage = "��ݼ�Ϊ�գ�����׼����ݼ���";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tMNewsSchema = new MNewsSchema();
			tMNewsSchema.setSchema(mResultSet, 1);
			tMNewsSet.add(tMNewsSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tMNewsSchema = new MNewsSchema();
					tMNewsSchema.setSchema(mResultSet, 1);
					tMNewsSet.add(tMNewsSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "MNewsDB";
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
		return tMNewsSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
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
				tError.moduleName = "MNewsDB";
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
			tError.moduleName = "MNewsDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
