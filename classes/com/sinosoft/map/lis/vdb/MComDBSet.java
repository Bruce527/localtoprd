// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MComDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MComSchema;
import com.sinosoft.map.lis.vschema.MComSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MComDBSet extends MComSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MComDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MCom");
		mflag = true;
	}

	public MComDBSet()
	{
		mflag = false;
		db = new DBOper("MCom");
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
			tError.moduleName = "MComDBSet";
			tError.functionName = "deleteSQL";
			tError.errorMessage = "²Ù×÷Ê§°Ü!";
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
			pstmt = con.prepareStatement("DELETE FROM MCom WHERE  ComCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComCode());
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
			tError.moduleName = "MComDBSet";
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
			pstmt = con.prepareStatement("UPDATE MCom SET  ComCode = ? , OutComCode = ? , Name = ? , ShortName = ? , Address = ? , ZipCode = ? , Phone = ? , Fax = ? , EMail = ? , WebAddress = ? , SatrapName = ? , InsuMonitorCode = ? , InsureID = ? , SignID = ? , Country = ? , Province = ? , City = ? , ComNature = ? , ValidCode = ? , Sign = ? WHERE  ComCode = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComCode());
				if (get(i).getOutComCode() == null || get(i).getOutComCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getOutComCode());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getName());
				if (get(i).getShortName() == null || get(i).getShortName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getShortName());
				if (get(i).getAddress() == null || get(i).getAddress().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getZipCode());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPhone());
				if (get(i).getFax() == null || get(i).getFax().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFax());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getEMail());
				if (get(i).getWebAddress() == null || get(i).getWebAddress().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getWebAddress());
				if (get(i).getSatrapName() == null || get(i).getSatrapName().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getSatrapName());
				if (get(i).getInsuMonitorCode() == null || get(i).getInsuMonitorCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getInsuMonitorCode());
				if (get(i).getInsureID() == null || get(i).getInsureID().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getInsureID());
				if (get(i).getSignID() == null || get(i).getSignID().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getSignID());
				if (get(i).getCountry() == null || get(i).getCountry().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCountry());
				if (get(i).getProvince() == null || get(i).getProvince().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getProvince());
				if (get(i).getCity() == null || get(i).getCity().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCity());
				if (get(i).getComNature() == null || get(i).getComNature().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getComNature());
				if (get(i).getValidCode() == null || get(i).getValidCode().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getValidCode());
				if (get(i).getSign() == null || get(i).getSign().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSign());
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(21, null);
				else
					pstmt.setString(21, get(i).getComCode());
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
			tError.moduleName = "MComDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MCom VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getComCode() == null || get(i).getComCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getComCode());
				if (get(i).getOutComCode() == null || get(i).getOutComCode().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getOutComCode());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getName());
				if (get(i).getShortName() == null || get(i).getShortName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getShortName());
				if (get(i).getAddress() == null || get(i).getAddress().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getAddress());
				if (get(i).getZipCode() == null || get(i).getZipCode().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getZipCode());
				if (get(i).getPhone() == null || get(i).getPhone().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getPhone());
				if (get(i).getFax() == null || get(i).getFax().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getFax());
				if (get(i).getEMail() == null || get(i).getEMail().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getEMail());
				if (get(i).getWebAddress() == null || get(i).getWebAddress().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getWebAddress());
				if (get(i).getSatrapName() == null || get(i).getSatrapName().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getSatrapName());
				if (get(i).getInsuMonitorCode() == null || get(i).getInsuMonitorCode().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getInsuMonitorCode());
				if (get(i).getInsureID() == null || get(i).getInsureID().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getInsureID());
				if (get(i).getSignID() == null || get(i).getSignID().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getSignID());
				if (get(i).getCountry() == null || get(i).getCountry().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getCountry());
				if (get(i).getProvince() == null || get(i).getProvince().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getProvince());
				if (get(i).getCity() == null || get(i).getCity().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getCity());
				if (get(i).getComNature() == null || get(i).getComNature().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getComNature());
				if (get(i).getValidCode() == null || get(i).getValidCode().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getValidCode());
				if (get(i).getSign() == null || get(i).getSign().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getSign());
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
			tError.moduleName = "MComDBSet";
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
