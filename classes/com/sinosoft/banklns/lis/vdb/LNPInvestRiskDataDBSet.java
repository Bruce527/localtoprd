// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   LNPInvestRiskDataDBSet.java

package com.sinosoft.banklns.lis.vdb;

import com.sinosoft.banklns.lis.schema.LNPInvestRiskDataSchema;
import com.sinosoft.banklns.lis.vschema.LNPInvestRiskDataSet;
import com.sinosoft.banklns.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LNPInvestRiskDataDBSet extends LNPInvestRiskDataSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public LNPInvestRiskDataDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "LNPInvestRiskData");
		mflag = true;
	}

	public LNPInvestRiskDataDBSet()
	{
		mflag = false;
		db = new DBOper("LNPInvestRiskData");
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
			tError.moduleName = "LNPInvestRiskDataDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM LNPInvestRiskData WHERE  Dataid = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDataid() == null || get(i).getDataid().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDataid());
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
			tError.moduleName = "LNPInvestRiskDataDBSet";
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
			pstmt = con.prepareStatement("UPDATE LNPInvestRiskData SET  Dataid = ? , Signno = ? , Type = ? , Serialno = ? , Age = ? , Degree = ? , Value = ? , Protagonist = ? , exponent = ? , banlance = ? , solidity = ? , prevent = ? , remark1 = ? , remark2 = ? , remark3 = ? , remark4 = ? WHERE  Dataid = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDataid() == null || get(i).getDataid().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDataid());
				if (get(i).getSignno() == null || get(i).getSignno().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getSignno());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getSerialno());
				pstmt.setInt(5, get(i).getAge());
				pstmt.setInt(6, get(i).getDegree());
				pstmt.setDouble(7, get(i).getValue());
				pstmt.setInt(8, get(i).getProtagonist());
				pstmt.setInt(9, get(i).getExponent());
				pstmt.setInt(10, get(i).getBanlance());
				pstmt.setInt(11, get(i).getSolidity());
				pstmt.setInt(12, get(i).getPrevent());
				if (get(i).getRemark1() == null || get(i).getRemark1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRemark1());
				if (get(i).getRemark2() == null || get(i).getRemark2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRemark2());
				if (get(i).getRemark3() == null || get(i).getRemark3().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getRemark3());
				if (get(i).getRemark4() == null || get(i).getRemark4().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getRemark4());
				if (get(i).getDataid() == null || get(i).getDataid().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getDataid());
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
			tError.moduleName = "LNPInvestRiskDataDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO LNPInvestRiskData VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getDataid() == null || get(i).getDataid().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getDataid());
				if (get(i).getSignno() == null || get(i).getSignno().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getSignno());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getType());
				pstmt.setInt(4, get(i).getSerialno());
				pstmt.setInt(5, get(i).getAge());
				pstmt.setInt(6, get(i).getDegree());
				pstmt.setDouble(7, get(i).getValue());
				pstmt.setInt(8, get(i).getProtagonist());
				pstmt.setInt(9, get(i).getExponent());
				pstmt.setInt(10, get(i).getBanlance());
				pstmt.setInt(11, get(i).getSolidity());
				pstmt.setInt(12, get(i).getPrevent());
				if (get(i).getRemark1() == null || get(i).getRemark1().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getRemark1());
				if (get(i).getRemark2() == null || get(i).getRemark2().equals("null"))
					pstmt.setString(14, null);
				else
					pstmt.setString(14, get(i).getRemark2());
				if (get(i).getRemark3() == null || get(i).getRemark3().equals("null"))
					pstmt.setString(15, null);
				else
					pstmt.setString(15, get(i).getRemark3());
				if (get(i).getRemark4() == null || get(i).getRemark4().equals("null"))
					pstmt.setString(16, null);
				else
					pstmt.setString(16, get(i).getRemark4());
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
			tError.moduleName = "LNPInvestRiskDataDBSet";
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
