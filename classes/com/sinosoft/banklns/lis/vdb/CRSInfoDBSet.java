// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CRSInfoDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.CRSInfoSchema;
import com.sinosoft.banklns.lis.vschema.CRSInfoSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CRSInfoDBSet extends CRSInfoSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public CRSInfoDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "CRSInfo");
		mflag = true;
	}

	public CRSInfoDBSet()
	{
		mflag = false;
		db = new DBOper("CRSInfo");
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
			tError.moduleName = "CRSInfoDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "???????!";
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
			pstmt = con.prepareStatement("DELETE FROM CRSInfo WHERE  ContNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
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
			tError.moduleName = "CRSInfoDBSet";
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
			pstmt = con.prepareStatement("UPDATE CRSInfo SET  contNo=?, CustomerName = ?,taxResidentType=?, firstName=?, lastName=?, birthday=?, currentAddress_Country=?,currentAddress_Province=?,currentAddress_City=?,currentAddress_Detail=?,currentAddress_Country_en=?, currentAddress_Province_en=?, currentAddress_City_en=?,currentAddress_Detail_en=?, birthAddress_Country=?, birthAddress_Province=?,birthAddress_City=?,birthAddress_Detail=?,birthAddress_Country_en=?,birthAddress_Province_en=?,birthAddress_City_en=?,birthAddress_Detail_en=?,taxResidentCountry1=?,taxpayerCode1=?,taxResidentCountry2=?,taxpayerCode2=?,taxResidentCountry3=?,taxpayerCode3=?,noTaxpayercodeReason=?,reasonDescription=?,sourceType=?  WHERE  ContNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
				if (get(i).getCustomerName() == null || get(i).getCustomerName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerName());
				if (get(i).getTaxResidentType() == null || get(i).getTaxResidentType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getTaxResidentType());
				if (get(i).getFirstName() == null || get(i).getFirstName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFirstName());
				if (get(i).getLastName() == null || get(i).getLastName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getLastName());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBirthday());
				if (get(i).getCurrentAddress_Country() == null || get(i).getCurrentAddress_Country().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCurrentAddress_Country());
				if (get(i).getCurrentAddress_Province() == null || get(i).getCurrentAddress_Province().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCurrentAddress_Province());
				if (get(i).getCurrentAddress_City() == null || get(i).getCurrentAddress_City().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCurrentAddress_City());
				if (get(i).getCurrentAddress_Detail() == null || get(i).getCurrentAddress_Detail().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCurrentAddress_Detail());
				if (get(i).getCurrentAddress_Country_en() == null || get(i).getCurrentAddress_Country_en().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCurrentAddress_Country_en());
				if (get(i).getCurrentAddress_Province_en() == null || get(i).getCurrentAddress_Province_en().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCurrentAddress_Province_en());
				if (get(i).getCurrentAddress_City_en() == null || get(i).getCurrentAddress_City_en().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCurrentAddress_City_en());
				if (get(i).getCurrentAddress_Detail_en() == null || get(i).getCurrentAddress_Detail_en().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCurrentAddress_Detail_en());
				if (get(i).getBirthAddress_Country() == null || get(i).getBirthAddress_Country().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getBirthAddress_Country());
				if (get(i).getBirthAddress_Province() == null || get(i).getBirthAddress_Province().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getBirthAddress_Province());
				if (get(i).getBirthAddress_City() == null || get(i).getBirthAddress_City().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getBirthAddress_City());
				if (get(i).getBirthAddress_Detail() == null || get(i).getBirthAddress_Detail().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getBirthAddress_Detail());
				if (get(i).getBirthAddress_Country_en() == null || get(i).getBirthAddress_Country_en().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getBirthAddress_Country_en());
				if (get(i).getBirthAddress_Province_en() == null || get(i).getBirthAddress_Province_en().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getBirthAddress_Province_en());
				if (get(i).getBirthAddress_City_en() == null || get(i).getBirthAddress_City_en().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getBirthAddress_City_en());
				if (get(i).getBirthAddress_Detail_en() == null || get(i).getBirthAddress_Detail_en().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getBirthAddress_Detail_en());
				if (get(i).getTaxResidentCountry1() == null || get(i).getTaxResidentCountry1().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getTaxResidentCountry1());
				if (get(i).getTaxpayerCode1() == null || get(i).getTaxpayerCode1().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getTaxpayerCode1());
				if (get(i).getTaxResidentCountry2() == null || get(i).getTaxResidentCountry2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getTaxResidentCountry2());
				if (get(i).getTaxpayerCode2() == null || get(i).getTaxpayerCode2().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getTaxpayerCode2());
				if (get(i).getTaxResidentCountry3() == null || get(i).getTaxResidentCountry3().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getTaxResidentCountry3());
				if (get(i).getTaxpayerCode3() == null || get(i).getTaxpayerCode3().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getTaxpayerCode3());
				if (get(i).getNoTaxpayercodeReason() == null || get(i).getNoTaxpayercodeReason().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getNoTaxpayercodeReason());
				if (get(i).getReasonDescription() == null || get(i).getReasonDescription().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getReasonDescription());
				if (get(i).getSourceType() == null || get(i).getSourceType().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getSourceType());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(32, null);
				else
					pstmt.setString(32, get(i).getContNo());
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
			tError.moduleName = "CRSInfoDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO CRSInfo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
				if (get(i).getCustomerName() == null || get(i).getCustomerName().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerName());
				if (get(i).getTaxResidentType() == null || get(i).getTaxResidentType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getTaxResidentType());
				if (get(i).getFirstName() == null || get(i).getFirstName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getFirstName());
				if (get(i).getLastName() == null || get(i).getLastName().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getLastName());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getBirthday());
				if (get(i).getCurrentAddress_Country() == null || get(i).getCurrentAddress_Country().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getCurrentAddress_Country());
				if (get(i).getCurrentAddress_Province() == null || get(i).getCurrentAddress_Province().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getCurrentAddress_Province());
				if (get(i).getCurrentAddress_City() == null || get(i).getCurrentAddress_City().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getCurrentAddress_City());
				if (get(i).getCurrentAddress_Detail() == null || get(i).getCurrentAddress_Detail().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getCurrentAddress_Detail());
				if (get(i).getCurrentAddress_Country_en() == null || get(i).getCurrentAddress_Country_en().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getCurrentAddress_Country_en());
				if (get(i).getCurrentAddress_Province_en() == null || get(i).getCurrentAddress_Province_en().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getCurrentAddress_Province_en());
				if (get(i).getCurrentAddress_City_en() == null || get(i).getCurrentAddress_City_en().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getCurrentAddress_City_en());
				if (get(i).getCurrentAddress_Detail_en() == null || get(i).getCurrentAddress_Detail_en().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getCurrentAddress_Detail_en());
				if (get(i).getBirthAddress_Country() == null || get(i).getBirthAddress_Country().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getBirthAddress_Country());
				if (get(i).getBirthAddress_Province() == null || get(i).getBirthAddress_Province().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getBirthAddress_Province());
				if (get(i).getBirthAddress_City() == null || get(i).getBirthAddress_City().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getBirthAddress_City());
				if (get(i).getBirthAddress_Detail() == null || get(i).getBirthAddress_Detail().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getBirthAddress_Detail());
				if (get(i).getBirthAddress_Country_en() == null || get(i).getBirthAddress_Country_en().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getBirthAddress_Country_en());
				if (get(i).getBirthAddress_Province_en() == null || get(i).getBirthAddress_Province_en().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getBirthAddress_Province_en());
				if (get(i).getBirthAddress_City_en() == null || get(i).getBirthAddress_City_en().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getBirthAddress_City_en());
				if (get(i).getBirthAddress_Detail_en() == null || get(i).getBirthAddress_Detail_en().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getBirthAddress_Detail_en());
				if (get(i).getTaxResidentCountry1() == null || get(i).getTaxResidentCountry1().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getTaxResidentCountry1());
				if (get(i).getTaxpayerCode1() == null || get(i).getTaxpayerCode1().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getTaxpayerCode1());
				if (get(i).getTaxResidentCountry2() == null || get(i).getTaxResidentCountry2().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getTaxResidentCountry2());
				if (get(i).getTaxpayerCode2() == null || get(i).getTaxpayerCode2().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getTaxpayerCode2());
				if (get(i).getTaxResidentCountry3() == null || get(i).getTaxResidentCountry3().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getTaxResidentCountry3());
				if (get(i).getTaxpayerCode3() == null || get(i).getTaxpayerCode3().equals("null"))
					pstmt.setString(28, null);
				else
					pstmt.setString(28, get(i).getTaxpayerCode3());
				if (get(i).getNoTaxpayercodeReason() == null || get(i).getNoTaxpayercodeReason().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getNoTaxpayercodeReason());
				if (get(i).getReasonDescription() == null || get(i).getReasonDescription().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getReasonDescription());
				if (get(i).getSourceType() == null || get(i).getSourceType().equals("null"))
					pstmt.setString(31, null);
				else
					pstmt.setString(31, get(i).getSourceType());
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
			tError.moduleName = "CRSInfoDBSet";
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
