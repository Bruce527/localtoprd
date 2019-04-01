// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPAddressDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPAddressSchema;
import com.sinosoft.banklns.lis.vschema.LNPAddressSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPAddressDBSet extends LNPAddressSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPAddressDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPAddress");
		mflag = true;
	}

	public LNPAddressDBSet()
	{
		mflag = false;
		db = new DBOper("LNPAddress");
		con = db.getConnection();
	}

	public boolean deleteSQL()
	{
		if (db.deleteSQL(this))
		{
			return true;
		} else
		{
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "����ʧ��!";
			mErrors.addOneError(tError);
			return false;
		}
	}

	public boolean delete()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("DELETE FROM LNPAddress WHERE  CustomerId = ? AND AddressNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getAddressNo());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDBSet";
			tError.functionName = "delete()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean update()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("UPDATE LNPAddress SET  CustomerId = ? , CustomerNo = ? , AddressNo = ? , PostalAddress = ? , ZipCode = ? , Phone = ? , Fax = ? , duchy = ? , HomeAddress = ? , HomeZipCode = ? , HomePhone = ? , HomeFax = ? , CompanyAddress = ? , CompanyZipCode = ? , CompanyPhone = ? , CompanyFax = ? , CompanyMail = ? , Mobile = ? , MobileChs = ? , EMail = ? , BP = ? , Mobile2 = ? , MobileChs2 = ? , EMail2 = ? , BP2 = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , GrpName = ? , OtherDuchy = ? WHERE  CustomerId = ? AND AddressNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAddressNo());
				if (get(i).getPostalAddress() == null || get(i).getPostalAddress().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPostalAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getZipCode());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPhone());
				if (get(i).getFax() == null || get(i).getFax().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getFax());
				if (get(i).getDuchy() == null || get(i).getDuchy().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDuchy());
				if (get(i).getHomeAddress() == null || get(i).getHomeAddress().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getHomeAddress());
				if (get(i).getHomeZipCode() == null || get(i).getHomeZipCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getHomeZipCode());
				if (get(i).getHomePhone() == null || get(i).getHomePhone().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getHomePhone());
				if (get(i).getHomeFax() == null || get(i).getHomeFax().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getHomeFax());
				if (get(i).getCompanyAddress() == null || get(i).getCompanyAddress().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCompanyAddress());
				if (get(i).getCompanyZipCode() == null || get(i).getCompanyZipCode().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCompanyZipCode());
				if (get(i).getCompanyPhone() == null || get(i).getCompanyPhone().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCompanyPhone());
				if (get(i).getCompanyFax() == null || get(i).getCompanyFax().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCompanyFax());
				if (get(i).getCompanyMail() == null || get(i).getCompanyMail().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCompanyMail());
				if (get(i).getMobile() == null || get(i).getMobile().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMobile());
				if (get(i).getMobileChs() == null || get(i).getMobileChs().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMobileChs());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getEMail());
				if (get(i).getBP() == null || get(i).getBP().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getBP());
				if (get(i).getMobile2() == null || get(i).getMobile2().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getMobile2());
				if (get(i).getMobileChs2() == null || get(i).getMobileChs2().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getMobileChs2());
				if (get(i).getEMail2() == null || get(i).getEMail2().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEMail2());
				if (get(i).getBP2() == null || get(i).getBP2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getBP2());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(29, null);
				else
					pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getModifyTime());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getGrpName());
				if (get(i).getOtherDuchy() == null || get(i).getOtherDuchy().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOtherDuchy());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(33, null);
				else
					pstmt.setString(33, get(i).getCustomerId());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(34, null);
				else
					pstmt.setString(34, get(i).getAddressNo());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDBSet";
			tError.functionName = "update()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}

	public boolean insert()
	{
		PreparedStatement pstmt = null;
		if (!mflag)
			con = DBConnPool.getConnection();
		try
		{
			int tCount = size();
			pstmt = con.prepareStatement("INSERT INTO LNPAddress VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerNo());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getAddressNo());
				if (get(i).getPostalAddress() == null || get(i).getPostalAddress().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getPostalAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getZipCode());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPhone());
				if (get(i).getFax() == null || get(i).getFax().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getFax());
				if (get(i).getDuchy() == null || get(i).getDuchy().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getDuchy());
				if (get(i).getHomeAddress() == null || get(i).getHomeAddress().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getHomeAddress());
				if (get(i).getHomeZipCode() == null || get(i).getHomeZipCode().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getHomeZipCode());
				if (get(i).getHomePhone() == null || get(i).getHomePhone().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getHomePhone());
				if (get(i).getHomeFax() == null || get(i).getHomeFax().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getHomeFax());
				if (get(i).getCompanyAddress() == null || get(i).getCompanyAddress().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCompanyAddress());
				if (get(i).getCompanyZipCode() == null || get(i).getCompanyZipCode().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCompanyZipCode());
				if (get(i).getCompanyPhone() == null || get(i).getCompanyPhone().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCompanyPhone());
				if (get(i).getCompanyFax() == null || get(i).getCompanyFax().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getCompanyFax());
				if (get(i).getCompanyMail() == null || get(i).getCompanyMail().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCompanyMail());
				if (get(i).getMobile() == null || get(i).getMobile().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getMobile());
				if (get(i).getMobileChs() == null || get(i).getMobileChs().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMobileChs());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getEMail());
				if (get(i).getBP() == null || get(i).getBP().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getBP());
				if (get(i).getMobile2() == null || get(i).getMobile2().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getMobile2());
				if (get(i).getMobileChs2() == null || get(i).getMobileChs2().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getMobileChs2());
				if (get(i).getEMail2() == null || get(i).getEMail2().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEMail2());
				if (get(i).getBP2() == null || get(i).getBP2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getBP2());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(27, null);
				else
					pstmt.setDate(27, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(29, null);
				else
					pstmt.setDate(29, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getModifyTime());
				if (get(i).getGrpName() == null || get(i).getGrpName().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getGrpName());
				if (get(i).getOtherDuchy() == null || get(i).getOtherDuchy().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getOtherDuchy());
				pstmt.addBatch();
			}

			pstmt.executeBatch();
			pstmt.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			mErrors.copyAllErrors(db.mErrors);
			CError tError = new CError();
			tError.moduleName = "LNPAddressDBSet";
			tError.functionName = "insert()";
			tError.errorMessage = ex.toString();
			mErrors.addOneError(tError);
			try
			{
				pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			if (!mflag)
				try
				{
					con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			return false;
		}
		if (!mflag)
			try
			{
				con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return true;
	}
}
