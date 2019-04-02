// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAddressDB.java

package com.sinosoft.banklns.lis.db;

import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAddressDB extends LNPAddressSchema
{

	private Connection con;
	private DBOper db;
	private boolean mflag;
	public CErrors mErrors;
	private ResultSet mResultSet;
	private Statement mStatement;

	public LNPAddressDB(Connection tConnection)
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = tConnection;
		db = new DBOper(con, "LNPAddress");
		mflag = true;
	}

	public LNPAddressDB()
	{
		mflag = false;
		mErrors = new CErrors();
		mResultSet = null;
		mStatement = null;
		con = null;
		db = new DBOper("LNPAddress");
		mflag = false;
	}

	public boolean deleteSQL()
	{
		LNPAddressSchema tSchema = getSchema();
		if (db.deleteSQL(tSchema))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "操作失败!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public int getCount()
	{
		LNPAddressSchema tSchema = getSchema();
		int tCount = db.getCount(tSchema);
		if (tCount < 0)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
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
			pstmt = con.prepareStatement("DELETE FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getAddressNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
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
			pstmt = con.prepareStatement("UPDATE LNPAddress SET  CustomerId = ? , CustomerNo = ? , AddressNo = ? , PostalAddress = ? , ZipCode = ? , Phone = ? , Fax = ? , duchy = ? , HomeAddress = ? , HomeZipCode = ? , HomePhone = ? , HomeFax = ? , CompanyAddress = ? , CompanyZipCode = ? , CompanyPhone = ? , CompanyFax = ? , CompanyMail = ? , Mobile = ? , MobileChs = ? , EMail = ? , BP = ? , Mobile2 = ? , MobileChs2 = ? , EMail2 = ? , BP2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? , OtherDuchy = ? WHERE  CustomerId = ? AND AddressNo = ?");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerNo());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAddressNo());
			if (getPostalAddress() == null || getPostalAddress().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPostalAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getZipCode());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPhone());
			if (getFax() == null || getFax().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFax());
			if (getDuchy() == null || getDuchy().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDuchy());
			if (getHomeAddress() == null || getHomeAddress().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getHomeAddress());
			if (getHomeZipCode() == null || getHomeZipCode().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getHomeZipCode());
			if (getHomePhone() == null || getHomePhone().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getHomePhone());
			if (getHomeFax() == null || getHomeFax().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getHomeFax());
			if (getCompanyAddress() == null || getCompanyAddress().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCompanyAddress());
			if (getCompanyZipCode() == null || getCompanyZipCode().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCompanyZipCode());
			if (getCompanyPhone() == null || getCompanyPhone().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCompanyPhone());
			if (getCompanyFax() == null || getCompanyFax().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCompanyFax());
			if (getCompanyMail() == null || getCompanyMail().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCompanyMail());
			if (getMobile() == null || getMobile().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getMobile());
			if (getMobileChs() == null || getMobileChs().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMobileChs());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getEMail());
			if (getBP() == null || getBP().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getBP());
			if (getMobile2() == null || getMobile2().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getMobile2());
			if (getMobileChs2() == null || getMobileChs2().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getMobileChs2());
			if (getEMail2() == null || getEMail2().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getEMail2());
			if (getBP2() == null || getBP2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getBP2());
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
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getGrpName());
			if (getOtherDuchy() == null || getOtherDuchy().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getOtherDuchy());
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(33, 12);
			else
				pstmt.setString(33, getCustomerId());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(34, 12);
			else
				pstmt.setString(34, getAddressNo());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
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
			pstmt = con.prepareStatement("INSERT INTO LNPAddress VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			if (getCustomerId() == null || getCustomerId().equals("null"))
				pstmt.setNull(1, 12);
			else
				pstmt.setString(1, getCustomerId());
			if (getCustomerNo() == null || getCustomerNo().equals("null"))
				pstmt.setNull(2, 12);
			else
				pstmt.setString(2, getCustomerNo());
			if (getAddressNo() == null || getAddressNo().equals("null"))
				pstmt.setNull(3, 12);
			else
				pstmt.setString(3, getAddressNo());
			if (getPostalAddress() == null || getPostalAddress().equals("null"))
				pstmt.setNull(4, 12);
			else
				pstmt.setString(4, getPostalAddress());
			if (getZipCode() == null || getZipCode().equals("null"))
				pstmt.setNull(5, 12);
			else
				pstmt.setString(5, getZipCode());
			if (getPhone() == null || getPhone().equals("null"))
				pstmt.setNull(6, 12);
			else
				pstmt.setString(6, getPhone());
			if (getFax() == null || getFax().equals("null"))
				pstmt.setNull(7, 12);
			else
				pstmt.setString(7, getFax());
			if (getDuchy() == null || getDuchy().equals("null"))
				pstmt.setNull(8, 12);
			else
				pstmt.setString(8, getDuchy());
			if (getHomeAddress() == null || getHomeAddress().equals("null"))
				pstmt.setNull(9, 12);
			else
				pstmt.setString(9, getHomeAddress());
			if (getHomeZipCode() == null || getHomeZipCode().equals("null"))
				pstmt.setNull(10, 12);
			else
				pstmt.setString(10, getHomeZipCode());
			if (getHomePhone() == null || getHomePhone().equals("null"))
				pstmt.setNull(11, 12);
			else
				pstmt.setString(11, getHomePhone());
			if (getHomeFax() == null || getHomeFax().equals("null"))
				pstmt.setNull(12, 12);
			else
				pstmt.setString(12, getHomeFax());
			if (getCompanyAddress() == null || getCompanyAddress().equals("null"))
				pstmt.setNull(13, 12);
			else
				pstmt.setString(13, getCompanyAddress());
			if (getCompanyZipCode() == null || getCompanyZipCode().equals("null"))
				pstmt.setNull(14, 12);
			else
				pstmt.setString(14, getCompanyZipCode());
			if (getCompanyPhone() == null || getCompanyPhone().equals("null"))
				pstmt.setNull(15, 12);
			else
				pstmt.setString(15, getCompanyPhone());
			if (getCompanyFax() == null || getCompanyFax().equals("null"))
				pstmt.setNull(16, 12);
			else
				pstmt.setString(16, getCompanyFax());
			if (getCompanyMail() == null || getCompanyMail().equals("null"))
				pstmt.setNull(17, 12);
			else
				pstmt.setString(17, getCompanyMail());
			if (getMobile() == null || getMobile().equals("null"))
				pstmt.setNull(18, 12);
			else
				pstmt.setString(18, getMobile());
			if (getMobileChs() == null || getMobileChs().equals("null"))
				pstmt.setNull(19, 12);
			else
				pstmt.setString(19, getMobileChs());
			if (getEMail() == null || getEMail().equals("null"))
				pstmt.setNull(20, 12);
			else
				pstmt.setString(20, getEMail());
			if (getBP() == null || getBP().equals("null"))
				pstmt.setNull(21, 12);
			else
				pstmt.setString(21, getBP());
			if (getMobile2() == null || getMobile2().equals("null"))
				pstmt.setNull(22, 12);
			else
				pstmt.setString(22, getMobile2());
			if (getMobileChs2() == null || getMobileChs2().equals("null"))
				pstmt.setNull(23, 12);
			else
				pstmt.setString(23, getMobileChs2());
			if (getEMail2() == null || getEMail2().equals("null"))
				pstmt.setNull(24, 12);
			else
				pstmt.setString(24, getEMail2());
			if (getBP2() == null || getBP2().equals("null"))
				pstmt.setNull(25, 12);
			else
				pstmt.setString(25, getBP2());
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
			if (getGrpName() == null || getGrpName().equals("null"))
				pstmt.setNull(31, 12);
			else
				pstmt.setString(31, getGrpName());
			if (getOtherDuchy() == null || getOtherDuchy().equals("null"))
				pstmt.setNull(32, 12);
			else
				pstmt.setString(32, getOtherDuchy());
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch (Exception ex)
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
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
		pstmt = con.prepareStatement("SELECT * FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?", 1003, 1007);
		if (getCustomerId() == null || getCustomerId().equals("null"))
			pstmt.setNull(1, 12);
		else
			pstmt.setString(1, getCustomerId());
		if (getAddressNo() == null || getAddressNo().equals("null"))
			pstmt.setNull(2, 12);
		else
			pstmt.setString(2, getAddressNo());
		rs = pstmt.executeQuery();
		i = 0;
		if (!rs.next())
			break MISSING_BLOCK_LABEL_237;
		i++;
		if (setSchema(rs, i))
			break MISSING_BLOCK_LABEL_237;
		CError tError = new CError();
		tError.moduleName = "LNPAddressDB";
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
				tError.moduleName = "LNPAddressDB";
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

	public LNPAddressSet query()
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAddressSet aLNPAddressSet = new LNPAddressSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAddress");
			LNPAddressSchema aSchema = getSchema();
			sqlObj.setSQL(5, aSchema);
			String sql = sqlObj.getSQL();
			rs = stmt.executeQuery(sql);
			int i = 0;
			LNPAddressSchema s1;
			for (; rs.next(); aLNPAddressSet.add(s1))
			{
				i++;
				s1 = new LNPAddressSchema();
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
			tError.moduleName = "LNPAddressDB";
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
		return aLNPAddressSet;
	}

	public LNPAddressSet executeQuery(String sql)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAddressSet aLNPAddressSet = new LNPAddressSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			rs = stmt.executeQuery(StrTool.GBKToUnicode(sql));
			int i = 0;
			LNPAddressSchema s1;
			for (; rs.next(); aLNPAddressSet.add(s1))
			{
				i++;
				s1 = new LNPAddressSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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
		return aLNPAddressSet;
	}

	public LNPAddressSet query(int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAddressSet aLNPAddressSet = new LNPAddressSet();
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			stmt = con.createStatement(1003, 1007);
			SQLString sqlObj = new SQLString("LNPAddress");
			LNPAddressSchema aSchema = getSchema();
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
				LNPAddressSchema s1 = new LNPAddressSchema();
				s1.setSchema(rs, i);
				aLNPAddressSet.add(s1);
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
			tError.moduleName = "LNPAddressDB";
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
		return aLNPAddressSet;
	}

	public LNPAddressSet executeQuery(String sql, int nStart, int nCount)
	{
		Statement stmt = null;
		ResultSet rs = null;
		LNPAddressSet aLNPAddressSet = new LNPAddressSet();
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
				LNPAddressSchema s1 = new LNPAddressSchema();
				if (!s1.setSchema(rs, i))
				{
					CError tError = new CError();
					tError.moduleName = "LNPAddressDB";
					tError.functionName = "executeQuery";
					tError.errorMessage = "sql语句有误，请查看表名及字段名信息!";
					mErrors.addOneError(tError);
				}
				aLNPAddressSet.add(s1);
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
			tError.moduleName = "LNPAddressDB";
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
		return aLNPAddressSet;
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
				SQLString sqlObj = new SQLString("LNPAddress");
				LNPAddressSchema aSchema = getSchema();
				sqlObj.setSQL(2, aSchema);
				String sql = (new StringBuilder("update LNPAddress ")).append(sqlObj.getUpdPart()).append(" where ").append(strWherePart).toString();
				int operCount = stmt.executeUpdate(sql);
				if (operCount != 0)
					break label0;
				CError tError = new CError();
				tError.moduleName = "LNPAddressDB";
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
				tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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

	public LNPAddressSet getData()
	{
		int tCount = 0;
		LNPAddressSet tLNPAddressSet = new LNPAddressSet();
		LNPAddressSchema tLNPAddressSchema = null;
		if (mResultSet == null)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
			tError.functionName = "getData";
			tError.errorMessage = "数据集为空，请先准备数据集！";
			mErrors.addOneError(tError);
			return null;
		}
		try
		{
			tCount = 1;
			tLNPAddressSchema = new LNPAddressSchema();
			tLNPAddressSchema.setSchema(mResultSet, 1);
			tLNPAddressSet.add(tLNPAddressSchema);
			while (tCount++ < 5000) 
				if (mResultSet.next())
				{
					tLNPAddressSchema = new LNPAddressSchema();
					tLNPAddressSchema.setSchema(mResultSet, 1);
					tLNPAddressSet.add(tLNPAddressSchema);
				}
		}
		catch (Exception ex)
		{
			CError tError = new CError();
			tError.moduleName = "LNPAddressDB";
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
		return tLNPAddressSet;
	}

	public boolean closeData()
	{
		boolean flag = true;
		try
		{
			if (mResultSet == null)
			{
				CError tError = new CError();
				tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
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
				tError.moduleName = "LNPAddressDB";
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
			tError.moduleName = "LNPAddressDB";
			tError.functionName = "closeData";
			tError.errorMessage = ex3.toString();
			mErrors.addOneError(tError);
			flag = false;
		}
		return flag;
	}
}
