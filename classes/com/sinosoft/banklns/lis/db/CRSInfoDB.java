// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CRSInfoDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
import com.sinosoft.banklns.utility.*;
import java.io.PrintStream;
import java.sql.*;

public class CRSInfoDB extends CRSInfoSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public CRSInfoDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper("CRSInfo");
		mflag = false;
	}

	public CRSInfoDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("CRSInfo");
		mflag = false;
	}

	public int getCount()
	{
		CRSInfoSchema oSchema = getSchema();
		int tCount = db.getCount(oSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CRSInfoDB";
			tError.functionName = "getCount";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return -1;
		} else
		{
			return tCount;
		}
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			pstmt = con.prepareStatement("UPDATE CRSInfo SET  contNo=?, CustomerName = ?,taxResidentType=?, firstName=?, lastName=?, birthday=?, currentAddress_Country=?,currentAddress_Province=?,currentAddress_City=?,currentAddress_Detail=?,currentAddress_Country_en=?, currentAddress_Province_en=?, currentAddress_City_en=?,currentAddress_Detail_en=?, birthAddress_Country=?, birthAddress_Province=?,birthAddress_City=?,birthAddress_Detail=?,birthAddress_Country_en=?,birthAddress_Province_en=?,birthAddress_City_en=?,birthAddress_Detail_en=?,taxResidentCountry1=?,taxpayerCode1=?,taxResidentCountry2=?,taxpayerCode2=?,taxResidentCountry3=?,taxpayerCode3=?,noTaxpayercodeReason=?,reasonDescription=?,sourceType=?  WHERE  ContNo = ?");
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			if (getCustomerName() == null || getCustomerName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerName());
			if (getTaxResidentType() == null || getTaxResidentType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getTaxResidentType());
			if (getFirstName() == null || getFirstName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getFirstName());
			if (getLastName() == null || getLastName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getLastName());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBirthday());
			if (getCurrentAddress_Country() == null || getCurrentAddress_Country().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCurrentAddress_Country());
			if (getCurrentAddress_Province() == null || getCurrentAddress_Province().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCurrentAddress_Province());
			if (getCurrentAddress_City() == null || getCurrentAddress_City().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCurrentAddress_City());
			if (getCurrentAddress_Detail() == null || getCurrentAddress_Detail().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getCurrentAddress_Detail());
			if (getCurrentAddress_Country_en() == null || getCurrentAddress_Country_en().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getCurrentAddress_Country_en());
			if (getCurrentAddress_Province_en() == null || getCurrentAddress_Province_en().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCurrentAddress_Province_en());
			if (getCurrentAddress_City_en() == null || getCurrentAddress_City_en().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCurrentAddress_City_en());
			if (getCurrentAddress_Detail_en() == null || getCurrentAddress_Detail_en().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCurrentAddress_Detail_en());
			if (getBirthAddress_Country() == null || getBirthAddress_Country().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getBirthAddress_Country());
			if (getBirthAddress_Province() == null || getBirthAddress_Province().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getBirthAddress_Province());
			if (getBirthAddress_City() == null || getBirthAddress_City().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getBirthAddress_City());
			if (getBirthAddress_Detail() == null || getBirthAddress_Detail().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getBirthAddress_Detail());
			if (getBirthAddress_Country_en() == null || getBirthAddress_Country_en().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getBirthAddress_Country_en());
			if (getBirthAddress_Province_en() == null || getBirthAddress_Province_en().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getBirthAddress_Province_en());
			if (getBirthAddress_City_en() == null || getBirthAddress_City_en().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getBirthAddress_City_en());
			if (getBirthAddress_Detail_en() == null || getBirthAddress_Detail_en().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getBirthAddress_Detail_en());
			if (getTaxResidentCountry1() == null || getTaxResidentCountry1().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getTaxResidentCountry1());
			if (getTaxpayerCode1() == null || getTaxpayerCode1().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getTaxpayerCode1());
			if (getTaxResidentCountry2() == null || getTaxResidentCountry2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getTaxResidentCountry2());
			if (getTaxpayerCode2() == null || getTaxpayerCode2().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getTaxpayerCode2());
			if (getTaxResidentCountry3() == null || getTaxResidentCountry3().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getTaxResidentCountry3());
			if (getTaxpayerCode3() == null || getTaxpayerCode3().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getTaxpayerCode3());
			if (getNoTaxpayercodeReason() == null || getNoTaxpayercodeReason().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getNoTaxpayercodeReason());
			if (getReasonDescription() == null || getReasonDescription().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getReasonDescription());
			if (getSourceType() == null || getSourceType().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getSourceType());
			if (getContNo() == null || getContNo().equals("null"))
			{
				pstmt.setNull(32, 12);
			} else
			{
				pstmt.setString(32, getContNo());
				pstmt.executeUpdate();
				pstmt.close();
			}
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CRSInfoDB";
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
			String sql = "INSERT INTO CRSInfo VALUES(  ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
			pstmt = con.prepareStatement(sql);
			System.out.println((new StringBuilder("插入语句为：：")).append(sql).toString());
			if (getContNo() == null || getContNo().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getContNo());
			if (getCustomerName() == null || getCustomerName().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerName());
			if (getTaxResidentType() == null || getTaxResidentType().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getTaxResidentType());
			if (getFirstName() == null || getFirstName().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getFirstName());
			if (getLastName() == null || getLastName().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getLastName());
			if (getBirthday() == null || getBirthday().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getBirthday());
			if (getCurrentAddress_Country() == null || getCurrentAddress_Country().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getCurrentAddress_Country());
			if (getCurrentAddress_Province() == null || getCurrentAddress_Province().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getCurrentAddress_Province());
			if (getCurrentAddress_City() == null || getCurrentAddress_City().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getCurrentAddress_City());
			if (getCurrentAddress_Detail() == null || getCurrentAddress_Detail().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getCurrentAddress_Detail());
			if (getCurrentAddress_Country_en() == null || getCurrentAddress_Country_en().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getCurrentAddress_Country_en());
			if (getCurrentAddress_Province_en() == null || getCurrentAddress_Province_en().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getCurrentAddress_Province_en());
			if (getCurrentAddress_City_en() == null || getCurrentAddress_City_en().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCurrentAddress_City_en());
			if (getCurrentAddress_Detail_en() == null || getCurrentAddress_Detail_en().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCurrentAddress_Detail_en());
			if (getBirthAddress_Country() == null || getBirthAddress_Country().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getBirthAddress_Country());
			if (getBirthAddress_Province() == null || getBirthAddress_Province().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getBirthAddress_Province());
			if (getBirthAddress_City() == null || getBirthAddress_City().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getBirthAddress_City());
			if (getBirthAddress_Detail() == null || getBirthAddress_Detail().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getBirthAddress_Detail());
			if (getBirthAddress_Country_en() == null || getBirthAddress_Country_en().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getBirthAddress_Country_en());
			if (getBirthAddress_Province_en() == null || getBirthAddress_Province_en().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getBirthAddress_Province_en());
			if (getBirthAddress_City_en() == null || getBirthAddress_City_en().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getBirthAddress_City_en());
			if (getBirthAddress_Detail_en() == null || getBirthAddress_Detail_en().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getBirthAddress_Detail_en());
			if (getTaxResidentCountry1() == null || getTaxResidentCountry1().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getTaxResidentCountry1());
			if (getTaxpayerCode1() == null || getTaxpayerCode1().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getTaxpayerCode1());
			if (getTaxResidentCountry2() == null || getTaxResidentCountry2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getTaxResidentCountry2());
			if (getTaxpayerCode2() == null || getTaxpayerCode2().equals("null"))
				pstmt.setNull(26, 12);
			else
				pstmt.setString(26, getTaxpayerCode2());
			if (getTaxResidentCountry3() == null || getTaxResidentCountry3().equals("null"))
				pstmt.setNull(27, 12);
			else
				pstmt.setString(27, getTaxResidentCountry3());
			if (getTaxpayerCode3() == null || getTaxpayerCode3().equals("null"))
				pstmt.setNull(28, 12);
			else
				pstmt.setString(28, getTaxpayerCode3());
			if (getNoTaxpayercodeReason() == null || getNoTaxpayercodeReason().equals("null"))
				pstmt.setNull(29, 12);
			else
				pstmt.setString(29, getNoTaxpayercodeReason());
			if (getReasonDescription() == null || getReasonDescription().equals("null"))
				pstmt.setNull(30, 12);
			else
				pstmt.setString(30, getReasonDescription());
			if (getSourceType() == null || getSourceType().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getSourceType());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "CRSInfoDB";
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
		pstmt = con.prepareStatement("SELECT * FROM CRSInfo WHERE  ContNo = ?", 1003, 1007);
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
		tError.moduleName = "CRSInfoDB";
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
				tError.moduleName = "CRSInfoDB";
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

	public CRSInfoSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		CRSInfoSet aCRSInfoSet = new CRSInfoSet();
		System.out.println((new StringBuilder("执行query--flag--false=")).append(mflag).toString());
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("CRSInfo");
			CRSInfoSchema aSchema = getSchema();
			String a[] = aSchema.getPK();
			String as[];
			int k = (as = a).length;
			for (int j = 0; j < k; j++)
			{
				String string = as[j];
				System.out.println((new StringBuilder("pk=================")).append(string).toString());
			}

			System.out.println((new StringBuilder("主键所属schema")).append(aSchema.toString()).toString());
			sqlObj.setSQL(6, aSchema);
			String sql = sqlObj.getSQL();
			System.out.println((new StringBuilder("执行sql= ")).append(sql).toString());
			rs = stmt.executeQuery(sql);
			int i = 0;
			CRSInfoSchema s1;
			for (; rs.next(); aCRSInfoSet.add(s1))
			{
				i++;
				s1 = new CRSInfoSchema();
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
			tError.moduleName = "CRSInfoDB";
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
		return aCRSInfoSet;
	}

	public CRSInfoSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CRSInfoSet aCRSInfoSet = new CRSInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			CRSInfoSchema s1;
			for (; rs.next(); aCRSInfoSet.add(s1))
			{
				i++;
				s1 = new CRSInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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
		return aCRSInfoSet;
	}

	public CRSInfoSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CRSInfoSet aCRSInfoSet = new CRSInfoSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("CRSInfo");
			CRSInfoSchema aSchema = getSchema();
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
				CRSInfoSchema s1 = new CRSInfoSchema();
				s1.setSchema(rs, i);
				aCRSInfoSet.add(s1);
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
			tError.moduleName = "CRSInfoDB";
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
		return aCRSInfoSet;
	}

	public CRSInfoSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		CRSInfoSet aCRSInfoSet = new CRSInfoSet();
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
				CRSInfoSchema s1 = new CRSInfoSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "CRSInfoDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aCRSInfoSet.add(s1);
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
			tError.moduleName = "CRSInfoDB";
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
		return aCRSInfoSet;
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
				SQLString sqlObj = new SQLString("CRSInfo");
				CRSInfoSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update CRSInfo ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "CRSInfoDB";
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
				tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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

	public CRSInfoSet getData()
	{
		int tCount = 0;
		CRSInfoSet tCRSInfoSet = new CRSInfoSet();
		CRSInfoSchema tCRSInfoSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "CRSInfoDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tCRSInfoSchema = new CRSInfoSchema();
			tCRSInfoSchema.setSchema(mResultSet, 1);
			tCRSInfoSet.add(tCRSInfoSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tCRSInfoSchema = new CRSInfoSchema();
					tCRSInfoSchema.setSchema(mResultSet, 1);
					tCRSInfoSet.add(tCRSInfoSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "CRSInfoDB";
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
		return tCRSInfoSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
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
				tError.moduleName = "CRSInfoDB";
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
			tError.moduleName = "CRSInfoDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
