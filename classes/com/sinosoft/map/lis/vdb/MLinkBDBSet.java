// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MLinkBDBSet.java

package com.sinosoft.map.lis.vdb;

import com.sinosoft.map.lis.schema.MLinkBSchema;
import com.sinosoft.map.lis.vschema.MLinkBSet;
import com.sinosoft.map.utility.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MLinkBDBSet extends MLinkBSet
{

	private Connection con;
	private DBOper db;
	private boolean mflag;

	public MLinkBDBSet(Connection tConnection)
	{
		mflag = false;
		con = tConnection;
		db = new DBOper(con, "MLinkB");
		mflag = true;
	}

	public MLinkBDBSet()
	{
		mflag = false;
		db = new DBOper("MLinkB");
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
			tError.moduleName = "MLinkBDBSet";
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
			pstmt = con.prepareStatement("DELETE FROM MLinkB WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getEdorNo());
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
			tError.moduleName = "MLinkBDBSet";
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
			pstmt = con.prepareStatement("UPDATE MLinkB SET  ID = ? , RefURL = ? , Target = ? , Name = ? , LinkOrder = ? , State = ? , Type = ? , AgentCode = ? , Icon = ? , ManageCom = ? , BranchType = ? , VF01 = ? , NF01 = ? , IF01 = ? , DF02 = ? , Date01 = ? , ModifyOperator = ? , Operator = ? , MakeDate = ? , MakeTime = ? , ModifyDate = ? , ModifyTime = ? , Description = ? , EdorNo = ? , EdorType = ? , EdorCase = ? , Operator2 = ? , MakeDate2 = ? , MakeTime2 = ? WHERE  EdorNo = ?");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRefURL() == null || get(i).getRefURL().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRefURL());
				if (get(i).getTarget() == null || get(i).getTarget().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getTarget());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getName());
				pstmt.setInt(5, get(i).getLinkOrder());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getState());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentCode());
				if (get(i).getIcon() == null || get(i).getIcon().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getIcon());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getBranchType());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getNF01());
				pstmt.setInt(14, get(i).getIF01());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getModifyTime());
				if (get(i).getDescription() == null || get(i).getDescription().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getDescription());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator2());
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime2());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(30, null);
				else
					pstmt.setString(30, get(i).getEdorNo());
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
			tError.moduleName = "MLinkBDBSet";
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
			pstmt = con.prepareStatement("INSERT INTO MLinkB VALUES( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)");
			for (int i = 1; i <= tCount; i++)
			{
				if (get(i).getID() == null || get(i).getID().equals("null"))
					pstmt.setString(1, null);
				else
					pstmt.setString(1, get(i).getID());
				if (get(i).getRefURL() == null || get(i).getRefURL().equals("null"))
					pstmt.setString(2, null);
				else
					pstmt.setString(2, get(i).getRefURL());
				if (get(i).getTarget() == null || get(i).getTarget().equals("null"))
					pstmt.setString(3, null);
				else
					pstmt.setString(3, get(i).getTarget());
				if (get(i).getName() == null || get(i).getName().equals("null"))
					pstmt.setString(4, null);
				else
					pstmt.setString(4, get(i).getName());
				pstmt.setInt(5, get(i).getLinkOrder());
				if (get(i).getState() == null || get(i).getState().equals("null"))
					pstmt.setString(6, null);
				else
					pstmt.setString(6, get(i).getState());
				if (get(i).getType() == null || get(i).getType().equals("null"))
					pstmt.setString(7, null);
				else
					pstmt.setString(7, get(i).getType());
				if (get(i).getAgentCode() == null || get(i).getAgentCode().equals("null"))
					pstmt.setString(8, null);
				else
					pstmt.setString(8, get(i).getAgentCode());
				if (get(i).getIcon() == null || get(i).getIcon().equals("null"))
					pstmt.setString(9, null);
				else
					pstmt.setString(9, get(i).getIcon());
				if (get(i).getManageCom() == null || get(i).getManageCom().equals("null"))
					pstmt.setString(10, null);
				else
					pstmt.setString(10, get(i).getManageCom());
				if (get(i).getBranchType() == null || get(i).getBranchType().equals("null"))
					pstmt.setString(11, null);
				else
					pstmt.setString(11, get(i).getBranchType());
				if (get(i).getVF01() == null || get(i).getVF01().equals("null"))
					pstmt.setString(12, null);
				else
					pstmt.setString(12, get(i).getVF01());
				if (get(i).getNF01() == null || get(i).getNF01().equals("null"))
					pstmt.setString(13, null);
				else
					pstmt.setString(13, get(i).getNF01());
				pstmt.setInt(14, get(i).getIF01());
				if (get(i).getModifyOperator() == null || get(i).getModifyOperator().equals("null"))
					pstmt.setString(17, null);
				else
					pstmt.setString(17, get(i).getModifyOperator());
				if (get(i).getOperator() == null || get(i).getOperator().equals("null"))
					pstmt.setString(18, null);
				else
					pstmt.setString(18, get(i).getOperator());
				if (get(i).getMakeTime() == null || get(i).getMakeTime().equals("null"))
					pstmt.setString(20, null);
				else
					pstmt.setString(20, get(i).getMakeTime());
				if (get(i).getModifyTime() == null || get(i).getModifyTime().equals("null"))
					pstmt.setString(22, null);
				else
					pstmt.setString(22, get(i).getModifyTime());
				if (get(i).getDescription() == null || get(i).getDescription().equals("null"))
					pstmt.setString(23, null);
				else
					pstmt.setString(23, get(i).getDescription());
				if (get(i).getEdorNo() == null || get(i).getEdorNo().equals("null"))
					pstmt.setString(24, null);
				else
					pstmt.setString(24, get(i).getEdorNo());
				if (get(i).getEdorType() == null || get(i).getEdorType().equals("null"))
					pstmt.setString(25, null);
				else
					pstmt.setString(25, get(i).getEdorType());
				if (get(i).getEdorCase() == null || get(i).getEdorCase().equals("null"))
					pstmt.setString(26, null);
				else
					pstmt.setString(26, get(i).getEdorCase());
				if (get(i).getOperator2() == null || get(i).getOperator2().equals("null"))
					pstmt.setString(27, null);
				else
					pstmt.setString(27, get(i).getOperator2());
				if (get(i).getMakeTime2() == null || get(i).getMakeTime2().equals("null"))
					pstmt.setString(29, null);
				else
					pstmt.setString(29, get(i).getMakeTime2());
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
			tError.moduleName = "MLinkBDBSet";
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
