// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInsuredRelatedDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPInsuredRelatedSchema;
import com.sinosoft.banklns.lis.vschema.LNPInsuredRelatedSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPInsuredRelatedDBSet extends LNPInsuredRelatedSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPInsuredRelatedDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPInsuredRelated");
		mflag = true;
	}

	public LNPInsuredRelatedDBSet()
	{
		mflag = false;
		db = new DBOper("LNPInsuredRelated");
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
			tError.moduleName = "LNPInsuredRelatedDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPInsuredRelated WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPolNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerId());
				if (get(i).getMainCustomerNo() == null || get(i).getMainCustomerNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getMainCustomerNo());
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
			tError.moduleName = "LNPInsuredRelatedDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPInsuredRelated SET  PolNo = ? , CustomerId = ? , CustomerNo = ? , MainCustomerNo = ? , RelationToInsured = ? , AddressNo = ? , Name = ? , Sex = ? , Birthday = ? , IDType = ? , IDNo = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  PolNo = ? AND CustomerId = ? AND MainCustomerNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPolNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCustomerNo());
				if (get(i).getMainCustomerNo() == null || get(i).getMainCustomerNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMainCustomerNo());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRelationToInsured());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAddressNo());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getName());
				if (get(i).getSex() == null || get(i).getSex().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getSex());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getBirthday()));
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getIDNo());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getPolNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getCustomerId());
				if (get(i).getMainCustomerNo() == null || get(i).getMainCustomerNo().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getMainCustomerNo());
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
			tError.moduleName = "LNPInsuredRelatedDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPInsuredRelated VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getPolNo() == null || get(i).getPolNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getPolNo());
				if (get(i).getCustomerId() == null || get(i).getCustomerId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getCustomerId());
				if (get(i).getCustomerNo() == null || get(i).getCustomerNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getCustomerNo());
				if (get(i).getMainCustomerNo() == null || get(i).getMainCustomerNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getMainCustomerNo());
				if (get(i).getRelationToInsured() == null || get(i).getRelationToInsured().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getRelationToInsured());
				if (get(i).getAddressNo() == null || get(i).getAddressNo().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getAddressNo());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getName());
				if (get(i).getSex() == null || get(i).getSex().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getSex());
				if (get(i).getBirthday() == null || get(i).getBirthday().equals("null"))
					pstmt.setDate(9, null);
				else
					pstmt.setDate(9, Date.valueOf(get(i).getBirthday()));
				if (get(i).getIDType() == null || get(i).getIDType().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getIDType());
				if (get(i).getIDNo() == null || get(i).getIDNo().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getIDNo());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(13, null);
				else
					pstmt.setDate(13, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(15, null);
				else
					pstmt.setDate(15, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getModifyTime());
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
			tError.moduleName = "LNPInsuredRelatedDBSet";
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
