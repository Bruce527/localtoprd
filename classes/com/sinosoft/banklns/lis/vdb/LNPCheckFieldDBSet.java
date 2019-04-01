// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPCheckFieldDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPCheckFieldSchema;
import com.sinosoft.banklns.lis.vschema.LNPCheckFieldSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPCheckFieldDBSet extends LNPCheckFieldSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPCheckFieldDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPCheckField");
		mflag = true;
	}

	public LNPCheckFieldDBSet()
	{
		mflag = false;
		db = new DBOper("LNPCheckField");
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
			tError.moduleName = "LNPCheckFieldDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPCheckField WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getFieldName() == null || get(i).getFieldName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getFieldName());
				if (get(i).getSerialNo() == null || get(i).getSerialNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getSerialNo());
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
			tError.moduleName = "LNPCheckFieldDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPCheckField SET  RiskCode = ? , RiskVer = ? , FieldName = ? , SerialNo = ? , CalCode = ? , PageLocation = ? , Location = ? , Msg = ? , MsgFlag = ? , UpdFlag = ? , ValiFlag = ? , ReturnValiFlag = ? WHERE  RiskCode = ? AND RiskVer = ? AND FieldName = ? AND SerialNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getFieldName() == null || get(i).getFieldName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getFieldName());
				if (get(i).getSerialNo() == null || get(i).getSerialNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getSerialNo());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCalCode());
				if (get(i).getPageLocation() == null || get(i).getPageLocation().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPageLocation());
				if (get(i).getLocation() == null || get(i).getLocation().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getLocation());
				if (get(i).getMsg() == null || get(i).getMsg().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMsg());
				if (get(i).getMsgFlag() == null || get(i).getMsgFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMsgFlag());
				if (get(i).getUpdFlag() == null || get(i).getUpdFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getUpdFlag());
				if (get(i).getValiFlag() == null || get(i).getValiFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getValiFlag());
				if (get(i).getReturnValiFlag() == null || get(i).getReturnValiFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getReturnValiFlag());
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRiskVer());
				if (get(i).getFieldName() == null || get(i).getFieldName().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getFieldName());
				if (get(i).getSerialNo() == null || get(i).getSerialNo().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getSerialNo());
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
			tError.moduleName = "LNPCheckFieldDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPCheckField VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getRiskCode() == null || get(i).getRiskCode().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getRiskCode());
				if (get(i).getRiskVer() == null || get(i).getRiskVer().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRiskVer());
				if (get(i).getFieldName() == null || get(i).getFieldName().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getFieldName());
				if (get(i).getSerialNo() == null || get(i).getSerialNo().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getSerialNo());
				if (get(i).getCalCode() == null || get(i).getCalCode().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getCalCode());
				if (get(i).getPageLocation() == null || get(i).getPageLocation().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getPageLocation());
				if (get(i).getLocation() == null || get(i).getLocation().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getLocation());
				if (get(i).getMsg() == null || get(i).getMsg().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getMsg());
				if (get(i).getMsgFlag() == null || get(i).getMsgFlag().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getMsgFlag());
				if (get(i).getUpdFlag() == null || get(i).getUpdFlag().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getUpdFlag());
				if (get(i).getValiFlag() == null || get(i).getValiFlag().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getValiFlag());
				if (get(i).getReturnValiFlag() == null || get(i).getReturnValiFlag().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getReturnValiFlag());
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
			tError.moduleName = "LNPCheckFieldDBSet";
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
