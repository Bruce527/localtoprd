// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPIndUWPEMasterDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPIndUWPEMasterSchema;
import com.sinosoft.banklns.lis.vschema.LNPIndUWPEMasterSet;
import com.sinosoft.banklns.utility.*;
import java.sql.*;

public class LNPIndUWPEMasterDBSet extends LNPIndUWPEMasterSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPIndUWPEMasterDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPIndUWPEMaster");
		mflag = true;
	}

	public LNPIndUWPEMasterDBSet()
	{
		mflag = false;
		db = new DBOper("LNPIndUWPEMaster");
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
			tError.moduleName = "LNPIndUWPEMasterDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPIndUWPEMaster WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getInsuredId());
				if (get(i).getUWPENo() == null || get(i).getUWPENo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getUWPENo());
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
			tError.moduleName = "LNPIndUWPEMasterDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPIndUWPEMaster SET  GrpContNo = ? , ContNo = ? , ProposalContNo = ? , UWNo = ? , ManageCom = ? , UMDate = ? , UMTime = ? , InsuredId = ? , UWPENo = ? , PEName = ? , PECode = ? , PEStatus = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContNo = ? AND InsuredId = ? AND UWPENo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				pstmt.setInt(4, get(i).getUWNo());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getUMDate() == null || get(i).getUMDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getUMDate()));
				if (get(i).getUMTime() == null || get(i).getUMTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUMTime());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getInsuredId());
				if (get(i).getUWPENo() == null || get(i).getUWPENo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getUWPENo());
				if (get(i).getPEName() == null || get(i).getPEName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getPEName());
				if (get(i).getPECode() == null || get(i).getPECode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getPECode());
				if (get(i).getPEStatus() == null || get(i).getPEStatus().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPEStatus());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyTime());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getContNo());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(19, null);
				else
					pstmt.setString(19, get(i).getInsuredId());
				if (get(i).getUWPENo() == null || get(i).getUWPENo().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getUWPENo());
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
			tError.moduleName = "LNPIndUWPEMasterDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPIndUWPEMaster VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getGrpContNo() == null || get(i).getGrpContNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getGrpContNo());
				if (get(i).getContNo() == null || get(i).getContNo().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getContNo());
				if (get(i).getProposalContNo() == null || get(i).getProposalContNo().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getProposalContNo());
				pstmt.setInt(4, get(i).getUWNo());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getManageCom());
				if (get(i).getUMDate() == null || get(i).getUMDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getUMDate()));
				if (get(i).getUMTime() == null || get(i).getUMTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getUMTime());
				if (get(i).getInsuredId() == null || get(i).getInsuredId().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getInsuredId());
				if (get(i).getUWPENo() == null || get(i).getUWPENo().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getUWPENo());
				if (get(i).getPEName() == null || get(i).getPEName().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getPEName());
				if (get(i).getPECode() == null || get(i).getPECode().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getPECode());
				if (get(i).getPEStatus() == null || get(i).getPEStatus().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getPEStatus());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(14, null);
				else
					pstmt.setDate(14, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(16, null);
				else
					pstmt.setDate(16, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyTime());
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
			tError.moduleName = "LNPIndUWPEMasterDBSet";
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
