// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MNewsContentDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MNewsContentSchema;
import com.sinosoft.map.lis.vschema.MNewsContentSet;
import com.sinosoft.map.utility.*;
import java.sql.*;

public class MNewsContentDBSet extends MNewsContentSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MNewsContentDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MNewsContent");
		mflag = true;
	}

	public MNewsContentDBSet()
	{
		mflag = false;
		db = new DBOper("MNewsContent");
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
			tError.moduleName = "MNewsContentDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MNewsContent WHERE  ContentID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContentID() == null || get(i).getContentID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContentID());
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
			tError.moduleName = "MNewsContentDBSet";
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
			pstmt = con.prepareStatement("UPDATE MNewsContent SET  ContentID = ? , NewsID = ? , Content = ? , ContOrder = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? WHERE  ContentID = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContentID() == null || get(i).getContentID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContentID());
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNewsID());
				if (get(i).getContent() == null || get(i).getContent().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContent());
				pstmt.setInt(4, get(i).getContOrder());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getModifyTime());
				if (get(i).getContentID() == null || get(i).getContentID().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getContentID());
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
			tError.moduleName = "MNewsContentDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MNewsContent VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getContentID() == null || get(i).getContentID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getContentID());
				if (get(i).getNewsID() == null || get(i).getNewsID().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getNewsID());
				if (get(i).getContent() == null || get(i).getContent().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getContent());
				pstmt.setInt(4, get(i).getContOrder());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(5, null);
				else
					pstmt.setString(5, get(i).getOperator());
				if (get(i).getMakeDate() == null || get(i).getMakeDate().equals("null"))
					pstmt.setDate(6, null);
				else
					pstmt.setDate(6, Date.valueOf(get(i).getMakeDate()));
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getMakeTime());
				if (get(i).getModifyDate() == null || get(i).getModifyDate().equals("null"))
					pstmt.setDate(8, null);
				else
					pstmt.setDate(8, Date.valueOf(get(i).getModifyDate()));
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getModifyTime());
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
			tError.moduleName = "MNewsContentDBSet";
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
